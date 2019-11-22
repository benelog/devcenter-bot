package com.naver.hackday.devcenterbot.model;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.service.IssueService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TitleScrapper {

	private IssueQueue queue;
	private IssueService issueService;

	@Value("${spring.social.github.user}")
	private String user;

	@Value("${spring.social.github.repo}")
	private String repo;

	public TitleScrapper() {
		queue = new IssueQueue();
		issueService = new IssueService();
	}

	public IssueQueue run() throws IOException {

		List<Issue> listIssue =
			issueService.getIssues(this.user, this.repo, Collections.singletonMap("state", "open"));

		for (Issue item : listIssue) {
			queue.offer(item);
		}

		return queue;
	}

}

