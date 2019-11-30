package com.naver.hackday.devcenterbot.bot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.naver.hackday.devcenterbot.Message;
import com.naver.hackday.devcenterbot.model.BotRequest;
import com.naver.hackday.devcenterbot.model.MessageModel;
import com.naver.hackday.devcenterbot.persistence.BrainDao;

@Component
public class BotClassifier {
	private BrainDao brainDao;
	private Message message;

	@Value("${github.user}")
	private String user;

	@Value("${github.repo}")
	private String repo;

	@Autowired
	public BotClassifier(BrainDao brainDao, Message message) {
		this.brainDao = brainDao;
		this.message = message;
	}

	public void classify(BotRequest request) throws IOException {
		String issueNumber = request.getIssueNumber();

		int id = request.getId();
		String comment = fetchComment(id);

		submitComment(issueNumber, comment);
	}

	private String fetchComment(int id) {
		return this.brainDao.selectById(id).getComment();
	}

	private void submitComment(String issueNumber, String comment) throws IOException {
		var model = new MessageModel();
		model.setName(this.user);
		model.setRepoName(this.repo);
		model.setIssueNum(issueNumber);
		model.setComment(comment);

		message.pushMessage(model);
	}
}
