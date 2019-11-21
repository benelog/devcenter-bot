package com.naver.hackday.devcenterbot.model;

public class MessageModel {
	private String name;
	private String repoName;
	private String issueNum;
	private String comment;

	public String getName() {
		return name;
	}

	public String getRepoName() {
		return repoName;
	}

	public String getIssueNum() {
		return issueNum;
	}

	public String getComment() {
		return comment;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	public void setIssueNum(String issueNum) {
		this.issueNum = issueNum;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
