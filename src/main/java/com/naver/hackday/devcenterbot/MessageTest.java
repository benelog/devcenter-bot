package com.naver.hackday.devcenterbot;

import org.eclipse.egit.github.core.client.GitHubClient;
import org.springframework.stereotype.Component;

import com.naver.hackday.devcenterbot.model.MessageModel;

@Component
public class MessageTest {
	public static void test(){
		Message message;
		MessageModel model = new MessageModel();

		message = new Message();

		//RepositoryService service = new RepositoryService();
		model.setName("kkyehit");
		model.setRepoName("egit-github-test");
		model.setIssueNum("2");
		model.setComment("dev test");
		message.setModel(model);
		message.pushMessage();
	}
}
