package com.myimooc.wxdevadvanced.domain;

import java.util.List;

/**
 * 消息回复-图文消息
 * @author ZhangCheng on 2017-08-12
 *
 */
public class NewsMessage extends BaseMessage{
	
	private int ArticleCount;
	
	private List<News> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<News> getArticles() {
		return Articles;
	}

	public void setArticles(List<News> articles) {
		Articles = articles;
	}
	
}
