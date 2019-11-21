package com.naver.hackday.devcenterbot.model;

public class BotRequest {
	private int id;
	private RequestType keyword;
	private String issueNumber;

	public BotRequest() {
	}

	public BotRequest(Builder builder) {
		this.id = builder.id;
		this.keyword = builder.keyword;
		this.issueNumber = builder.issueNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setKeyword(RequestType keyword) {
		this.keyword = keyword;
	}

	public RequestType getKeyword() {
		return this.keyword;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getIssueNumber() {
		return this.issueNumber;
	}

	public static class Builder {
		int id;
		RequestType keyword;
		String issueNumber;

		public Builder() {
			this.id = 0;
			this.issueNumber = "";
		}

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder keyword(RequestType keyword) {
			this.keyword = keyword;
			return this;
		}

		public Builder issueNumber(String issueNumber) {
			this.issueNumber = issueNumber;
			return this;
		}

		public BotRequest build() {
			return new BotRequest(this);
		}
	}

	public static final Builder SMART_EDITOR_REQUEST =
		new Builder()
			.id(1)
			.keyword(RequestType.SMART_EDITOR_TYPE);

	public static final Builder NAVER_APP_REQUEST =
		new Builder()
			.id(2)
			.keyword(RequestType.NAVER_APP_TYPE);

	public static final Builder CLOUD_FUNDING_REQUEST =
		new Builder()
			.id(3)
			.keyword(RequestType.CLOUD_FUNDING_TYPE);

	public static final Builder NAVER_PAY_REQUEST =
		new Builder()
			.id(4)
			.keyword(RequestType.NAVER_PAY_TYPE);

	public static final Builder MAP_API_REQUEST =
		new Builder()
			.id(5)
			.keyword(RequestType.MAP_API_TYPE);

	public static final Builder BAND_API_TYPE =
		new Builder()
			.id(6)
			.keyword(RequestType.BAND_API_TYPE);

	public static final Builder WHALE_TYPE =
		new Builder()
			.id(7)
			.keyword(RequestType.WHALE_TYPE);
}
