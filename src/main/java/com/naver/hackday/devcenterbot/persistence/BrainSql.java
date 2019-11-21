package com.naver.hackday.devcenterbot.persistence;

public class BrainSql {
	public static final String SELECT_BY_ID =
		"SELECT id, comment FROM brain WHERE id = :id";

	public static final String UPDATE =
		"UPDATE brain SET comment = :comment WHERE id = :id";

	public static final String DELETE_BY_ID =
		"DELETE FROM brain WHERE id = :id";
}
