package com.naver.hackday.devcenterbot.entity;

public class CommentBlock {
	private String id;
	private String content;

	public CommentBlock() {
	}

	public CommentBlock(String id, String content) {
		this.id = id;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
