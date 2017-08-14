package com.java.main.conference.management;

import java.io.Serializable;
import java.util.List;


public class Referee implements Serializable {
	

	private static final long serialVersionUID = -7795276104752041633L;
	
	private String refereeName;
	private String refereeId;
	private String affiliation;
	private String phoneNumber;
	private String email;
	private List<Paper> papers;
	private int remindersReceived;
	
	public String getRefereeName() {
		return refereeName;
	}
	
	public void setRefereeName(String userName) {
		this.refereeName = userName.toUpperCase();
	}
	
	public String getRefereeId() {
		return refereeId;
	}
	
	public void setRefereeId(String userId) {
		this.refereeId = userId;
	}
	
	public String getAffiliation() {
		return affiliation;
	}
	
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation.toUpperCase();
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

	/**
	 * @return the remindersReceived
	 */
	public int getRemindersReceived() {
		return remindersReceived;
	}

	/**
	 * @param remindersReceived the remindersReceived to set
	 */
	public void setRemindersReceived(int remindersReceived) {
		this.remindersReceived = remindersReceived;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((refereeId == null) ? 0 : refereeId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Referee other = (Referee) obj;
		if (refereeId == null) {
			if (other.refereeId != null)
				return false;
		} else if (!refereeId.equals(other.refereeId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Referee Name: " + refereeName + ", \nReferee Id: " + refereeId
				+ ", \nAffiliation: " + affiliation + ", \nPhoneNumber: "
				+ phoneNumber + ", \nEmail: " + email;
	}
}
