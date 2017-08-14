package com.java.main.conference.management;

import java.util.LinkedList;
import java.util.List;


public class PaperRepository {
	
	private List<Paper> papers;
	
	public PaperRepository() {
		this.papers = new LinkedList<Paper>();	
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}
}
