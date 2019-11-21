package com.naver.hackday.devcenterbot.persistence;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.naver.hackday.devcenterbot.entity.CommentBlock;

@Repository
public class CommentBlockDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<CommentBlock> rowMapper = BeanPropertyRowMapper.newInstance(CommentBlock.class);

	public CommentBlockDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
			.withTableName("comment_block");
	}

	public void insert(CommentBlock block) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(block);
		insertAction.execute(params);
	}

	public CommentBlock selectById(String id) {
		var params = Map.of("id", id);
		return jdbc.queryForObject(CommentBlockSql.SELECT_BY_ID, params, rowMapper);
	}

	public List<CommentBlock> selectAll() {
		return jdbc.query(CommentBlockSql.SELECT_ALL, Map.of(), rowMapper);
	}

	public int update(CommentBlock block) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(block);
		return jdbc.update(CommentBlockSql.UPDATE, params);
	}

	public int deleteById(String id) {
		Map<String, ?> params = Map.of("id", id);
		return jdbc.update(CommentBlockSql.DELETE_BY_ID, params);
	}
}
