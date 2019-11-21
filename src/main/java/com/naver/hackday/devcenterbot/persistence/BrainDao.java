package com.naver.hackday.devcenterbot.persistence;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.naver.hackday.devcenterbot.entity.Brain;

@Repository
public class BrainDao {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private RowMapper<Brain> rowMapper = BeanPropertyRowMapper.newInstance(Brain.class);

	public BrainDao() {
	}

	@Autowired
	public BrainDao(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcInsert = new SimpleJdbcInsert(dataSource)
							.withTableName("brain");
	}

	public void insert(Brain brain) {
		var params = new BeanPropertySqlParameterSource(brain);
		jdbcInsert.execute(params);
	}

	public Brain selectById(int id) {
		var params = Map.of("id", id);
		return jdbcTemplate.queryForObject(BrainSql.SELECT_BY_ID, params, rowMapper);
	}

	public int update(Brain brain) {
		var params = new BeanPropertySqlParameterSource(brain);
		return jdbcTemplate.update(BrainSql.UPDATE, params);
	}

	public int delete(int id) {
		var params = Map.of("id", id);
		return jdbcTemplate.update(BrainSql.DELETE_BY_ID, params);
	}


}
