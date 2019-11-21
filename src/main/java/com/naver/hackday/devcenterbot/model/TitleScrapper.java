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

public class TitleScrapper {

	static IssueQueue queue;

	public TitleScrapper() {
		queue = new IssueQueue();
	}

	public IssueQueue run() throws IOException {

		//fileBase의 위치가 다를수도 있으므로..
		String fileName = "./src/main/resources/Files/log.txt";
		FileReader input = new FileReader(new File(fileName));
		BufferedReader br = new BufferedReader(input);
		int checkNumber = Integer.parseInt(br.readLine());
		IssueService issueService = new IssueService();
		HashMap<String, String> filter = new HashMap<String, String>();
		filter.put("direction", "asc");
		// 이슈는 무조건 숫자가 클수록 최신버전이 아님. 2. 0~10..
		List<Issue> listIssue = issueService.getIssues("kkyehit", "egit-github-test", filter);
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

