package com.naver.hackday.devcenterbot;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;

import com.naver.hackday.devcenterbot.model.MessageModel;

public class Message {
	private IssueService issueService;

	private GitHubClient client;

	private String token;

	private String id;

	private String password;

	private MessageModel model;

	public void setIssueService(IssueService issueService) {
		this.issueService = issueService;
	}

	public void setClient(GitHubClient client) {
		this.client = client;
	}

	public void setModel(MessageModel model) {
		this.model = model;
	}

	Message() {
		Properties properties;
		try {
			FileReader fileReader = new FileReader("src\\main\\resources\\application.properties");
			properties = new Properties();

			properties.load(fileReader);
			id = properties.getProperty("id");
			password = properties.getProperty("password");
			token = properties.getProperty("token");

			System.out.println("id : " + id + " password : " + password + " token : " + token);

			client = new GitHubClient();
			client.setCredentials(id, password);
			client.setOAuth2Token(token);
			issueService = new IssueService(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Message(GitHubClient client) {
		issueService = new IssueService(client);
	}

	Message(IssueService service) {
		issueService = service;
	}

	void pushMessage() throws IOException {
		issueService.createComment(
			model.getName(), model.getRepoName(),
			model.getIssueNum(), model.getComment()
		);
	}
}
