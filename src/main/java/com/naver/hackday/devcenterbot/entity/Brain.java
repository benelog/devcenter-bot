package com.naver.hackday.devcenterbot.entity;

public class Brain {
	private int id;
	private String comment;

	public Brain() {
	}

	public Brain(int id, String comment) {
		this.id = id;
		this.comment = comment;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	@Override
	public String toString() {
		return "Brain{" +
			"id=" + id +
			", comment='" + comment + '\'' +
			'}';
	}
}
