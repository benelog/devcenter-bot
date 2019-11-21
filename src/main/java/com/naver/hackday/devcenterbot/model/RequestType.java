package com.naver.hackday.devcenterbot.model;

public enum RequestType {

	SMART_EDITOR_TYPE("smart-editor"),
	NAVER_APP_TYPE("naver-app"),
	CLOUD_FUNDING_TYPE("cloud-funding"),
	NAVER_PAY_TYPE("naver-pay"),
	MAP_API_TYPE("map-api"),
	BAND_API_TYPE("band-api"),
	WHALE_TYPE("whale");

	private String word = "";

	RequestType() {
	}

	RequestType(String word) {
		this.word = word;
	}

	public String getWord() {
		return this.word;
	}

}
