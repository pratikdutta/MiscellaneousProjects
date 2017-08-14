package com.java.main.conference.management;

public interface CommiteeManagable {
	
	public void addReferee();
	
	public void removeReferee();
	
	public void recordSubmissionOfAPaper();
	
	public void displayAllReferees();
	
	public void displayPapers();
	
	public void assignPaperToAReferee();
	
	public void recordRefereeReport();
	
	public void papersPendingReports();
	
	public void recordReminderSent();
	
	public void displayPapersWith2Reports();
	
	public void recordCommiteeDecision();

}
