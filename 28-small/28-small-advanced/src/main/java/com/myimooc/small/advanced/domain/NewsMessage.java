package com.myimooc.small.advanced.domain;

import java.util.List;

/**
 * 消息回复-图文消息
 *
 * @author zc 2017-08-12
 */
public class NewsMessage extends BaseMessage {

    private int articleCount;

    private List<News> articles;

    @Override
    public String toString() {
        return super.toString() + "NewsMessage{" +
                "articleCount=" + articleCount +
                ", articles=" + articles +
                '}';
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }

}
