package com.java.main.conference.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApplicationHelper {

	private static List<Integer> ids = new ArrayList<Integer>();

	public static String generateRandomIds(String appender, int rng) {
		int range = rng;
		Random id = new Random();
		int intId = 0;
		if (ids.size() != 0) {
			intId = id.nextInt(100);
			for (int i : ids) {
				if (i == intId) {
					continue;
				} else {
					intId = id.nextInt(range);
					ids.add(intId);
					break;
				}
			}
		} else {
			intId = id.nextInt(100);
			ids.add(intId);
		}
		return appender + intId;
	}

	public static Referee fetchRefereeFromCommitee(String refId) {
		List<Referee> referees = Committee.getCommitee().getReferees();
		if (referees != null && referees.size() > 0) {
			for (final Referee ref : referees) {
				if (refId.equals(ref.getRefereeId())) {
					return ref;
				}
			}
		}
		return null;
	}

	public static Author fetchAuthorFromCommitee(String authId) {
		List<Author> authors = Committee.getCommitee().getAuthors();
		if (authors != null && authors.size() > 0) {
			for (final Author auth : authors) {
				if (authId.equals(auth.getUserId())) {
					return auth;
				}
			}
		}
		return null;
	}

	public static Paper fetchPaperFromCommitee(String paperId) {
		List<Paper> papers = Committee.getCommitee().getPapers();
		if (papers != null && papers.size() > 0) {
			for (final Paper paper : papers) {
				if (paperId.equals(paper.getPaperId())) {
					return paper;
				}
			}
		}
		return null;
	}

	public static Paper fetchPaperFromPaperRepo(String paperId) {
		List<Paper> papers = new PaperRepository().getPapers();
		if (papers != null && papers.size() > 0) {
			for (final Paper paper : papers) {
				if (paperId.equals(paper.getPaperId())) {
					return paper;
				}
			}
		}
		return null;
	}
}
