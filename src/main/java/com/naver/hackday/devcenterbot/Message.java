package com.naver.hackday.devcenterbot;

import java.io.IOException;

import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;
import org.springframework.stereotype.Component;

import com.naver.hackday.devcenterbot.model.MessageModel;

@Component
public class Message {
	private IssueService issueService;

	private GitHubClient client;

	MessageModel model;

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
		client = new GitHubClient();
		client.setCredentials("", "");
		client.setOAuth2Token("ee8e2420581221dc46085c8e4c156afb8cb63cb7");
		issueService = new IssueService(client);
	}

	Message(GitHubClient client) {
		issueService = new IssueService(client);
	}

	Message(IssueService service) {
		issueService = service;
	}

	void pushMessage() {
		//:System.out.println(model.getName() +"/"+ model.getRepoName() +"/"+ model.getIssueNum() +"/"+ model.getComment());
		try {
			issueService.createComment(model.getName(), model.getRepoName(), model.getIssueNum(), model.getComment());
		} catch (IOException e) {

		}
	}
}
