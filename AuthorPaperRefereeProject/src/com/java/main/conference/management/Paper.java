package com.java.main.conference.management;

import java.io.Serializable;
import java.util.List;

public class Paper implements Serializable {
	
	private static final long serialVersionUID = 21925751073911266L;
	
	private String name;
	private String paperId;
	private String description;
	private Author author;
	private List<Referee> referees;
	private PaperSize size;
	private String assignmentId;
	private java.util.Date assignmentDate;
	private Report report;
	private java.util.Date reportSubmissionDate;
	private Boolean reportReceived;
	private int remindersReceived;
	private String decision;
	
	enum PaperSize {
		REGULAR(10), SHORT(4);
		private int pages;

		PaperSize(int pages) {
			this.pages = pages;
		}

		public int getPages() {
			return this.pages;
		}
	}
	
	enum Report {
		ACCEPT_WITHOUT_CHANGES , ACCEPT_WITH_CHANGES, REJECT
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name.toUpperCase();
	}	
	
	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description.toUpperCase();
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public List<Referee> getReferees() {
		return referees;
	}
	
	public void setReferees(List<Referee> referees) {
		this.referees = referees;
	}	

	public PaperSize getSize() {
		return size;
	}

	public void setSize(PaperSize size) {
		this.size = size;
	}	

	public String getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(String assignmentId) {
		this.assignmentId = assignmentId;
	}	

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getReportSubmissionDate() {
		if(reportSubmissionDate == null){
			return "NOT SUBMITTED";
		}else{
			return reportSubmissionDate.toString();			
		}
	}

	public void setReportSubmissionDate(java.util.Date submissionDate) {
		this.reportSubmissionDate = submissionDate;
	}
	
	public String getAssignmentDate() {
		if(assignmentDate == null){
			return "NOT ASSIGNED";
		}else{
			return assignmentDate.toString();			
		}
	}

	public void setAssignmentDate(java.util.Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	public Boolean getReportReceived() {
		return reportReceived;
	}

	public void setReportReceived(Boolean reportReceived) {
		this.reportReceived = reportReceived;
	}

	/**
	 * @return the decision
	 */
	public String getDecision() {
		return decision;
	}

	/**
	 * @param decision the decision to set
	 */
	public void setDecision(String decision) {
		this.decision = decision;
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
		result = prime * result + ((paperId == null) ? 0 : paperId.hashCode());
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
		Paper other = (Paper) obj;
		if (paperId == null) {
			if (other.paperId != null)
				return false;
		} else if (!paperId.equals(other.paperId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paper Name: " + name + ",\nPaperId: " + paperId
				+ ",\nDescription: " + description + "\nSubmission Date: "+ reportSubmissionDate
				+ "\nAssigned On: "+ assignmentDate
				+ "\nNumber Of Referees Assigned To: " + this.referees.size();
	}
}

