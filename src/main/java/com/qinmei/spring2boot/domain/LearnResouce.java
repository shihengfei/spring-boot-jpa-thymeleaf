package com.qinmei.spring2boot.domain;

/**
 * 书实体,测试 thymeleaf 使用
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月21日下午12:59:22
 */
public class LearnResouce {

	/** 作者 */
	private String author;
	
	/** 标题 */
	private String title;
	
	/** 链接 */
	private String url;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LearnResouce(String author, String title, String url) {
		super();
		this.author = author;
		this.title = title;
		this.url = url;
	}

	public LearnResouce() {
		super();
	}
	
}
