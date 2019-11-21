package com.naver.hackday.devcenterbot.persistence;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
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

	public void insertAll() {
		Brain brain = new Brain();
		brain.setId(1);
		brain.setComment("스마트에디터에 대한 문의는 https://github.com/naver/smarteditor2/issues 에 등록 부탁드립니다");
		this.insert(brain);
		brain.setId(2);
		brain.setComment("네이버 앱에 대한 문의는 고객센터를 통해 지원해드리고 있습니다.\n"
			+ "\n"
			+ "https://m.help.naver.com/support/issue/report.nhn?serviceNo=5630");
		this.insert(brain);
		brain.setId(3);
		brain.setComment(
			"https://www.navercorp.com/naver/proposalGuide 페이지에서 제휴 제안으로 신청해주시면, 담당부서에서 검토를 한 후 안내를 드립니다.");
		this.insert(brain);
		brain.setId(4);
		brain.setComment("네이버페이는 별도의 개발자 센터와 판매자를 위한 사이트를 운영하고 있습니다.\n"
			+ "아래 사이트들에서 도움을 얻으실 수 있습니다.\n"
			+ "\n"
			+ "- https://developer.pay.naver.com/\n"
			+ "- https://admin.pay.naver.com");
		this.insert(brain);
		brain.setId(5);
		brain.setComment("네이버 지도 API는 더이상 개발자센터에서 제공되지 않습니다.\n"
			+ "\n"
			+ "ncloud 에서 지도 API에 대한 도움을 받으실수 있습니다.\n"
			+ "\n"
			+ "https://www.ncloud.com/support/question");
		this.insert(brain);
		brain.setId(6);
		brain.setComment("밴드는 별도의 개발자 센터를 운영하고 있습니다.\n"
			+ "https://developers.band.us/ 에서 도움을 얻으실 수 있습니다.");
		this.insert(brain);
		brain.setId(7);
		brain.setComment("웨일의 포럼은 아래에서 별도로 운영되고 있습니다.\n"
			+ "https://forum.whale.naver.com/");
		this.insert(brain);
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
