package com.naver.hackday.devcenterbot;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.naver.hackday.devcenterbot.model.MessageModel;

@SpringBootTest
class MessageTest {
	@Autowired
	Message message;

	@Test
	void pushMessage() throws IOException {
		MessageModel model = new MessageModel();
		model.setName("kkyehit");
		model.setRepoName("egit-github-test");
		model.setIssueNum("2");
		model.setComment("dev test test");

		message.pushMessage(model);
	}
}
