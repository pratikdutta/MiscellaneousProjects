package com.java.main.conference.management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Committee implements Serializable {

	private static final long serialVersionUID = -2248379182850005030L;

	private List<Paper> papers;
	private List<Author> authors;
	private List<Referee> referees;
	private PaperRepository repo;

	private static Committee commitee = new Committee();

	private Committee() {
		this.papers = new ArrayList<Paper>();
		this.authors = new ArrayList<Author>();
		this.referees = new ArrayList<Referee>();
		this.repo = new PaperRepository();
	}

	public PaperRepository getRepo() {
		return repo;
	}

	public void setRepo(PaperRepository repo) {
		this.repo = repo;
	}

	public static Committee getCommitee() {
		return commitee;
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Referee> getReferees() {
		return referees;
	}

	public void setReferees(List<Referee> referees) {
		this.referees = referees;
	}

	@Override
	public String toString() {
		return "Papers' Details: " + papers + ",\n\nAuthors' Details: "
				+ authors + ",\n\nReferees' Details" + referees
				+ ",\n\nAt Repository: " + repo.getPapers();
	}
}
