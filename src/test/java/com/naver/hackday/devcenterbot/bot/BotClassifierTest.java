package com.naver.hackday.devcenterbot.bot;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.naver.hackday.devcenterbot.entity.Brain;
import com.naver.hackday.devcenterbot.model.BotRequest;
import com.naver.hackday.devcenterbot.persistence.BrainDao;

@SpringBootTest
@Transactional
public class BotClassifierTest {

	@Autowired
	private BotClassifier botClassifier;

	@Autowired
	private BrainDao brainDao;

	@Test
	void checkRightAction() throws IOException {

		BotRequest botRequest = BotRequest.MAP_API_REQUEST.issueNumber(String.valueOf(3)).build();
		var brain = new Brain(botRequest.getId(), "지도 api 답변 테스트 완료");
		brainDao.insert(brain);

		this.botClassifier.classify(botRequest);
	}
}
