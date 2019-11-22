package com.naver.hackday.devcenterbot.bot;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.naver.hackday.devcenterbot.model.KeywordChecker;
import com.naver.hackday.devcenterbot.model.TitleScrapper;

@Service
@EnableScheduling
public class TaskRunner {
	private static final Logger logger = LoggerFactory.getLogger(TaskRunner.class);

	private TitleScrapper titleScrapper;
	private KeywordChecker keywordChecker;

	TaskRunner() {
	}

	@Autowired
	public TaskRunner(KeywordChecker keywordChecker) {
		this.keywordChecker = keywordChecker;
	}

	@Scheduled(fixedDelay = 5000)
	private void execute() throws IOException {
		logger.info("[TaskRunner] Run Bot !");
		titleScrapper = new TitleScrapper();
		keywordChecker.checkToTitle(titleScrapper.run());
	}

}
