package com.naver.hackday.devcenterbot.model;


public class BotRequest {
	private int id;
	private String keyword;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}
}
