package com.naver.hackday.devcenterbot.persistence;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.naver.hackday.devcenterbot.entity.CommentBlock;

@SpringBootTest
@Transactional
class CommentBlockDaoTest {
	@Autowired
	private CommentBlockDao dao;
	private static final String TEST_ID = "HEADER_1";

	@Test
	void insertAndSelect() {
		var block = new CommentBlock(TEST_ID, "안녕하세요");
		dao.insert(block);

		var created = dao.selectById(TEST_ID);
		assertThat(created.getContent()).isEqualTo("안녕하세요");
	}

	@Test
	void shouldUpdate() {
		var block1 = new CommentBlock(TEST_ID, "안녕하세요1");
		dao.insert(block1);

		var block2 = new CommentBlock(TEST_ID, "안녕하세요2");
		int affected = dao.update(block2);

		assertThat(affected).isEqualTo(1);
		CommentBlock updated = dao.selectById(TEST_ID);
		assertThat(updated.getContent()).isEqualTo("안녕하세요2");
	}

	@Test
	void shouldDelete() {
		var block1 = new CommentBlock(TEST_ID, "안녕하세요");
		dao.insert(block1);

		int affected = dao.deleteById(TEST_ID);

		assertThat(affected).isEqualTo(1);
	}
}
