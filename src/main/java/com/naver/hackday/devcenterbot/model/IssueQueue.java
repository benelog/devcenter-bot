package com.naver.hackday.devcenterbot.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.egit.github.core.Issue;

public class IssueQueue {
	private Queue<Issue> issueQueue;

	IssueQueue() {
		issueQueue = new ConcurrentLinkedQueue<>();
	}

	public void offer(Issue issue) {
		issueQueue.offer(issue);
	}

	public Issue poll() {
		return issueQueue.poll();
	}

	public boolean isEmpty() {
		return issueQueue.isEmpty();
	}
}
