package com.naver.hackday.devcenterbot;

import java.io.IOException;

import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.naver.hackday.devcenterbot.model.MessageModel;

@Component
public class Message {
	private final Logger logger = LoggerFactory.getLogger(Message.class);

	private IssueService issueService;

	private MessageModel model;

	public Message(
		@Value("${spring.social.github.token:#{systemProperties['GITHUB_TOKEN']}}") String token) {

		logger.info("token={}", token);
		var client = new GitHubClient();
		client.setOAuth2Token(token);
		issueService = new IssueService(client);
	}

	public void setModel(MessageModel model) {
		this.model = model;
	}

	public void pushMessage() throws IOException {
		issueService.createComment(
			model.getName(), model.getRepoName(),
			model.getIssueNum(), model.getComment()
		);
	}
}
