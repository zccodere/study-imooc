package com.myimooc.boot.es.simple.rest;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 图书REST接口类
 *
 * @author zc 2017-09-15
 */
@RestController
public class BookRest {

    @Autowired
    private TransportClient client;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 查询接口
     */
    @GetMapping("/get/book/novel")
    public ResponseEntity<?> get(@RequestParam(name = "id", defaultValue = "") String id) {

        if (id.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GetResponse result = this.client.prepareGet("book", "novel", id).get();

        if (!result.isExists()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result.getSource(), HttpStatus.OK);
    }

    /**
     * 增加接口
     */
    @PostMapping("/add/book/novel")
    public ResponseEntity<?> add(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "author") String author,
            @RequestParam(name = "word_count") int wordCount,
            @RequestParam(name = "publish_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date publishDate) {

        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title", title)
                    .field("author", author)
                    .field("word_count", wordCount)
                    .field("publish_date", publishDate.getTime())
                    .endObject();
            IndexResponse result = this.client.prepareIndex("book", "novel").setSource(content).get();
            return new ResponseEntity<>(result.getId(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 删除接口
     */
    @DeleteMapping("/delete/book/novel")
    public ResponseEntity<?> delete(@RequestParam(name = "id", defaultValue = "") String id) {
        DeleteResponse result = this.client.prepareDelete("book", "novel", id).get();
        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }

    /**
     * 修改接口
     */
    @DeleteMapping("/update/book/novel")
    public ResponseEntity<?> update(
            @RequestParam(name = "id", defaultValue = "") String id,
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "author", required = false) String author) {

        UpdateRequest update = new UpdateRequest("book", "novel", id);
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder()
                    .startObject();
            if (!StringUtils.isEmpty(title)) {
                builder.field("title", title);
            }
            if (!StringUtils.isEmpty(author)) {
                builder.field("author", author);
            }
            builder.endObject();
            update.doc(builder);
            UpdateResponse result = this.client.update(update).get();
            return new ResponseEntity<>(result.toString(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 复合查询
     */
    @DeleteMapping("/query/book/novel")
    public ResponseEntity<?> query(
            @RequestParam(name = "author", required = false) String author,
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "gt_word_count", defaultValue = "0") int gtWordCount,
            @RequestParam(name = "lt_word_count", required = false) Integer ltWordCount) {

        // 构建布尔查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (!StringUtils.isEmpty(author)) {
            boolQuery.must(QueryBuilders.matchQuery("author", author));
        }
        if (!StringUtils.isEmpty(title)) {
            boolQuery.must(QueryBuilders.matchQuery("title", title));
        }

        // 构建范围查询
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("word_count")
                .from(gtWordCount);
        if (ltWordCount != null && ltWordCount > 0) {
            rangeQuery.to(ltWordCount);
        }

        // 使用filter构建
        boolQuery.filter(rangeQuery);

        SearchRequestBuilder builder = this.client.prepareSearch("book")
                .setTypes("novel")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQuery)
                .setFrom(0)
                .setSize(10);

        System.out.println("[ES查询请求参数]：" + builder);

        SearchResponse response = builder.get();

        List<Map<String, Object>> result = new ArrayList<>();

        for (SearchHit hit : response.getHits()) {
            result.add(hit.getSourceAsMap());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
