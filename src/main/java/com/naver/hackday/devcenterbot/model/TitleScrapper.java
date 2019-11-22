package com.naver.hackday.devcenterbot.model;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.service.IssueService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TitleScrapper {

	private static final int BOT_SCHEDULE_PERIOD = 20000;
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
		long createdAt;
		long now;

		List<Issue> listIssue =
			issueService.getIssues(this.user, this.repo, Map.of("state", "open"));

		for (Issue item : listIssue) {
			createdAt = item.getCreatedAt().getTime();
			now = new Date().getTime();

			if(now - createdAt < BOT_SCHEDULE_PERIOD) {
				queue.offer(item);
			}
		}

		return queue;
	}

}

