package com.naver.hackday.devcenterbot.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.service.IssueService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TitleScrapper {

	static IssueQueue queue;

	@Value("${spring.social.github.user}")
	private String user;

	@Value("${spring.social.github.repo}")
	private String repo;

	public TitleScrapper() {
		queue = new IssueQueue();
	}

	public IssueQueue run() throws IOException {

		String fileName = "./src/main/resources/Files/log.txt";
		FileReader input = new FileReader(new File(fileName));
		BufferedReader br = new BufferedReader(input);
		int checkNumber = Integer.parseInt(br.readLine());
		IssueService issueService = new IssueService();
		HashMap<String, String> filter = new HashMap<String, String>();

		filter.put("direction", "asc");
		List<Issue> listIssue = issueService.getIssues(this.user, this.repo, filter);

		int size = listIssue.size();
		for (int num = checkNumber; num < size; num++) {
			Issue currentIssue = listIssue.get(num);
			queue.offer(currentIssue);
		}

		BufferedWriter out = new BufferedWriter(
			new FileWriter(new File(fileName)));

		out.write(String.valueOf(size) + "\n");
		out.flush();
		out.close();

		return queue;
	}

}

