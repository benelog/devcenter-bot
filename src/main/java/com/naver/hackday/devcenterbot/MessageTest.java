package com.naver.hackday.devcenterbot;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.naver.hackday.devcenterbot.model.MessageModel;

@Component
public class MessageTest {
	public static void test() {
		Message message;
		MessageModel model = new MessageModel();

		message = new Message();

		//RepositoryService service = new RepositoryService();
		model.setName("kkyehit");
		model.setRepoName("egit-github-test");
		model.setIssueNum("2");
		model.setComment("dev test test");
		message.setModel(model);

		try {
			message.pushMessage();
		} catch (IOException e) {
			e.printStackTrace();
			// 로깅 처리 필요
		}
	}
}
