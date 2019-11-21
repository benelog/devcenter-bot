package com.naver.hackday.devcenterbot.persistence;

public class CommentBlockSql {
	static final String SELECT_ALL =
		"SELECT id, content FROM comment_block";

	static final String SELECT_BY_ID =
		"SELECT id, content FROM comment_block WHERE id = :id";

	static final String UPDATE =
		"UPDATE comment_block SET content = :content WHERE id = :id";

	static final String DELETE_BY_ID =
		"DELETE FROM comment_block WHERE id= :id";
}
