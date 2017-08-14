package com.java.main.conference.management;

import com.java.main.conference.management.CommiteeManagementOperations;
import com.java.main.conference.management.ConferenceSystem;

public class ConferenceSystemBasicTester {

	public static void main(String[] args) {

		// Create an initial ConferenceSystem object
		ConferenceSystem sys = new ConferenceSystem();
		CommiteeManagementOperations op = sys.getOperation();
		
		// Display the ConferenceSystem object for inspection using a suitable toString
		System.out.println("Displaying the ConferenceSystem object for inspection using a suitable toString"); 		
		System.out.println(sys.getCommittee());
		
		// Add two referees
		for(int i=0; i<2; i++){
			op.addReferee();
		}
		System.out.println("\n\nDisplaying the ConferenceSystem object after addition of 2 referees");
		System.out.println(sys.getCommittee());
		
		// Record the submission of a paper
		op.recordSubmissionOfAPaper();
		System.out.println("\n\nDisplaying the ConferenceSystem object after recording submission of a paper");
		System.out.println(sys.getCommittee());
		
		// Record the assignment of the paper to two referees
		for(int i=0; i<2; i++){
			op.assignPaperToAReferee();
		}
		System.out.println("\n\nDisplaying the ConferenceSystem object after assignment of a paper to 2 referees");
		System.out.println(sys.getCommittee());
		
		// Record two referee reports
		for(int i=0; i<2; i++){
			op.recordRefereeReport();
		}
		System.out.println("\n\nDisplaying the ConferenceSystem object after recording reports of 2 referees");
		System.out.println(sys.getCommittee());
		
		// Record the decision of the committee about a paper.
		op.recordCommiteeDecision();
		System.out.println("\n\nDisplaying the ConferenceSystem object after recording commitee's decision on a paper.");
		System.out.println(sys.getCommittee());
	}

}
