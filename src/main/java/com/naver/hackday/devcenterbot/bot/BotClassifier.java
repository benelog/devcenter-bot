package com.naver.hackday.devcenterbot.bot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.naver.hackday.devcenterbot.Message;
import com.naver.hackday.devcenterbot.model.BotRequest;
import com.naver.hackday.devcenterbot.model.MessageModel;
import com.naver.hackday.devcenterbot.persistence.BrainDao;

@Component
public class BotClassifier {
	private BrainDao brainDao;
	private MessageModel model;
	private Message message;

	@Value("${spring.social.github.user}")
	private String user;

	@Value("${spring.social.github.repo}")
	private String repo;

	public BotClassifier(BrainDao brainDao, Message message) {
		this.brainDao = brainDao;
		this.message = message;
	}

	public void classify(BotRequest request) throws IOException {
		int id = request.getId();
		String issueNumber = request.getIssueNumber();
		String comment;

		//comment = fetchComment(id);
		comment = "123";
		submitComment(issueNumber, comment);
	}

	private String fetchComment(int id) {
		return this.brainDao.selectById(id).getComment();
	}

	private void submitComment(String issueNumber, String comment) throws IOException {
		this.model = new MessageModel();

		this.model.setName(this.user);
		this.model.setRepoName(this.repo);
		this.model.setIssueNum(issueNumber);
		this.model.setComment(comment);
		message.setModel(this.model);
		message.pushMessage();
	}
}
