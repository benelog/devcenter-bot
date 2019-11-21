package com.naver.hackday.devcenterbot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.naver.hackday.devcenterbot.model.BotRequest;

@SpringBootTest
class DevcenterBotApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testBotRequest() {
		BotRequest botRequest = new BotRequest();
		String testing = "smart-editor";
		BotRequest newRequest = BotRequest.SMART_EDITOR_REQUEST.build();
		assertThat(newRequest.getId()).isEqualTo(1);
		assertThat(newRequest.getKeyword().getWord()).isEqualTo(testing);
	}

}
