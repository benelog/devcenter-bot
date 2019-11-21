package com.naver.hackday.devcenterbot.persistence;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.naver.hackday.devcenterbot.entity.Brain;
import com.naver.hackday.devcenterbot.model.BotRequest;

@SpringBootTest
@Transactional
public class BrainDaoTest {

	private BrainDao brainDao;
	private BotRequest botRequest;

	@Autowired
	public void setBrainDao(BrainDao brainDao) {
		this.brainDao = brainDao;
	}

	@Test
	void insertAndSelectByIdTest() {
		botRequest = BotRequest.SMART_EDITOR_REQUEST.build();

		var brain = new Brain(botRequest.getId(), botRequest.getKeyword().getWord());
		brainDao.insert(brain);

		Brain testBrain = brainDao.selectById(botRequest.getId());

		assertThat(testBrain.getComment()).isEqualTo("smart-editor");
	}

	@Test
	void updateAndSelectTest() {
		var brain = new Brain(2, "comment first 삽입");
		brainDao.insert(brain);

		brain.setComment("comment 수정");
		int affected = brainDao.update(brain);

		assertThat(affected).isEqualTo(1);

		Brain testBrain = brainDao.selectById(2);

		assertThat(testBrain.getComment()).isEqualTo("comment 수정");
	}

	@Test
	void insertAndDeleteTest() {
		var brain = new Brain(3, "comment test");
		brainDao.insert(brain);

		int affected = brainDao.delete(3);

		assertThat(affected).isEqualTo(1);
	}
}
