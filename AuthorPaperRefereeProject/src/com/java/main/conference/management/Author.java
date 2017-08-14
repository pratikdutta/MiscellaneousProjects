package com.java.main.conference.management;

import java.io.Serializable;
import java.util.List;


public class Author implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5518762708130970646L;
	
	
	private String name;
	private String id;
	private String affiliation;
	private String phoneNumber;
	private String email;
	private List<Paper> papers;
	
	public String getUserName() {
		return name;
	}
	
	public void setUserName(String userName) {
		this.name = userName.toUpperCase();
	}
	
	public String getUserId() {
		return id;
	}

	public void setUserId(String userId) {
		this.id = userId;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}

	@Override
	public String toString() {
		return "Author Name:" + name + ", \nAuthorID:" + id + ", \nAffiliation:" + affiliation + ", \nPhoneNumber:"
				+ phoneNumber + ", \nemail:" + email;
	}
}
