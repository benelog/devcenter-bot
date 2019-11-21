package com.naver.hackday.devcenterbot.model;

import java.util.ArrayList;

public class KeywordChecker {
	private FilteringKeyword[] keywords = new FilteringKeyword[7];

	public KeywordChecker() {
		keywords[0] = new FilteringKeyword(1, new String[] {"네이버 에디터", "스마트에디터", "네이버에디터", "스마트 에디터"});
		keywords[1] = new FilteringKeyword(2, new String[] {"네이버 앱", "네이버앱"});
		keywords[2] = new FilteringKeyword(3, new String[] {"크라우드펀딩", "크라우드 펀딩"});
		keywords[3] = new FilteringKeyword(4, new String[] {"네이버 페이", "네이버페이", "Npay", "N pay"});
		keywords[4] = new FilteringKeyword(5, new String[] {"네이버지도", "지도", "네이버맵", "NaverMap", "네이버 지도"});
		keywords[5] = new FilteringKeyword(6, new String[] {"네이버밴드", "밴드", "네이버 밴드"});
		keywords[6] = new FilteringKeyword(7, new String[] {"네이버 웨일", "웨일", "웨일브라우저", "네이버웨일", "네이버웨일브라우저"});
	}

	public void checkToTitle(String title) {
		for (int keyType = 0; keyType < keywords.length; keyType++) {
			String[] currKey = keywords[keyType].getKeywords();
			int totalTypeKeyword = currKey.length;
			for (int checkerTypeIndex = 0; checkerTypeIndex < totalTypeKeyword; checkerTypeIndex++) {
				if (title.contains(currKey[checkerTypeIndex])) {
					classfiedBotRequest(keywords[keyType].getId(), title);
					break;
				}
			}
		}
	}

	public void classfiedBotRequest(int typeId, String title) {
		switch (typeId) {
			case 1:
				BotRequest.MAP_API_REQUEST.build();

		}
	}
}
