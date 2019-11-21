package com.naver.hackday.devcenterbot.model;

import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.egit.github.core.Issue;

public class IssueQueue {
	private Queue<Issue> issueQueue = new LinkedList<>();
	public void setterIssue(Issue issue) {
		issueQueue.add(issue);
	}

	public Issue getterIssue() {
		return issueQueue.poll();
	}
}
