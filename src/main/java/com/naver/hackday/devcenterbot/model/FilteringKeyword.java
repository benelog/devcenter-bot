package com.naver.hackday.devcenterbot.model;

public class FilteringKeyword {
	private int id;
	private String[] keywords;

	public FilteringKeyword(int id, String[] keywords) {
		this.id = id;
		this.keywords = keywords;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
}
