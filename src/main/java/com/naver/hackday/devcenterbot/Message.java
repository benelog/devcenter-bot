package com.naver.hackday.devcenterbot;

import java.io.IOException;

import javax.annotation.PostConstruct;

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

	private GitHubClient client;

	@Value("${token}")
	private String token;

	@Value("${id}")
	private String id;

	@Value("${password}")
	private String password;

	private MessageModel model;

	public Message() {

	}

	public void setIssueService(IssueService issueService) {
		this.issueService = issueService;
	}

	public void setClient(GitHubClient client) {
		this.client = client;
	}

	public void setModel(MessageModel model) {
		this.model = model;
	}

	@PostConstruct
	public void init() {
		logger.info("id : {},  password : {},  token {} ", id, password, token);

		client = new GitHubClient();
		client.setCredentials(id, password);
		client.setOAuth2Token(token);
		issueService = new IssueService(client);
	}

	Message(GitHubClient client) {
		issueService = new IssueService(client);
	}

	Message(IssueService service) {
		issueService = service;
	}

	public void pushMessage() throws IOException {
		issueService.createComment(
			model.getName(), model.getRepoName(),
			model.getIssueNum(), model.getComment()
		);

	}
}
