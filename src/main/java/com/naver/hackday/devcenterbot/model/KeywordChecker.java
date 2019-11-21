package com.naver.hackday.devcenterbot.model;

import org.eclipse.egit.github.core.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naver.hackday.devcenterbot.bot.BotClassifier;

@Component
public class KeywordChecker {
	private FilteringKeyword[] keywords = new FilteringKeyword[7];

	@Autowired
	BotClassifier botClassifier;

	public KeywordChecker() {
		keywords[0] = new FilteringKeyword(1, new String[] {"네이버 에디터", "스마트에디터", "네이버에디터", "스마트 에디터"});
		keywords[1] = new FilteringKeyword(2, new String[] {"네이버 앱", "네이버앱"});
		keywords[2] = new FilteringKeyword(3, new String[] {"크라우드펀딩", "크라우드 펀딩"});
		keywords[3] = new FilteringKeyword(4, new String[] {"네이버 페이", "네이버페이", "Npay", "N pay"});
		keywords[4] = new FilteringKeyword(5, new String[] {"네이버지도", "지도", "네이버맵", "NaverMap", "네이버 지도"});
		keywords[5] = new FilteringKeyword(6, new String[] {"네이버밴드", "밴드", "네이버 밴드"});
		keywords[6] = new FilteringKeyword(7, new String[] {"네이버 웨일", "웨일", "웨일브라우저", "네이버웨일", "네이버웨일브라우저"});
	}

	public void checkToTitle(IssueQueue queue) {
		while (!queue.isEmpty()) {
			Issue checkIssue = queue.poll();
			System.out.println(checkIssue.getTitle());
			for (int keyType = 0; keyType < keywords.length; keyType++) {
				String[] currKey = keywords[keyType].getKeywords();
				for (int checkerTypeIndex = 0; checkerTypeIndex < currKey.length; checkerTypeIndex++) {

					if (checkIssue == null) {
						break;
					}

					if ((checkIssue.getTitle()).contains(currKey[checkerTypeIndex])) {
						int id = keywords[keyType].getId();
						String issueNum = String.valueOf(checkIssue.getNumber());
						BotRequest bot = classfiedBotRequest
							(id, checkIssue.getTitle(), issueNum);

						try {
							botClassifier.classify(bot);
						} catch (Exception e) {
							e.printStackTrace();
						}

						break;
					}
				}
			}
		}
	}

	public BotRequest classfiedBotRequest(int typeId, String title, String issueNumber) {
		switch (typeId) {
			case 1:
				return BotRequest.SMART_EDITOR_REQUEST.issueNumber(issueNumber).build();
			case 2:
				return BotRequest.NAVER_APP_REQUEST.issueNumber(issueNumber).build();
			case 3:
				return BotRequest.CLOUD_FUNDING_REQUEST.issueNumber(issueNumber).build();
			case 4:
				return BotRequest.NAVER_PAY_REQUEST.issueNumber(issueNumber).build();
			case 5:
				return BotRequest.MAP_API_REQUEST.issueNumber(issueNumber).build();
			case 6:
				return BotRequest.BAND_API_TYPE.issueNumber(issueNumber).build();
			case 7:
				return BotRequest.WHALE_TYPE.issueNumber(issueNumber).build();
			default:
				return new BotRequest();
		}
	}
}
