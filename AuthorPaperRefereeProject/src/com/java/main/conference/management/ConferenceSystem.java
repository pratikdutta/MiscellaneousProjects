package com.java.main.conference.management;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConferenceSystem {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in));
	private CommiteeManagementOperations operation = new CommiteeManagementOperations(
			reader);

	public String getCommittee() {
		return Committee.getCommitee().toString();
	}

	public CommiteeManagementOperations getOperation() {
		return this.operation;
	}

	public void execute(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out
				.println("Welcome to the International Conference Management Commitee.");
		System.out
				.println("===============================================================================\n");

		while (true) {
			printWelcomeDetails();
			try {
				String inpStr = scan.next();
				Integer oprtnInput = null;
				try {
					oprtnInput = Integer.parseInt(inpStr);
				} catch (NumberFormatException nfe) {
					oprtnInput = 50; // Abitrary value for invalid inputs.
				}
				if (!Double.isNaN(oprtnInput)) {
					switch (oprtnInput) {

					case 1:// Add a Referee
						operation.addReferee();
						break;

					case 2: // Remove a referee
						operation.removeReferee();
						break;

					case 3: // Record the submission of a paper.
						operation.recordSubmissionOfAPaper();
						break;

					case 4: // List all referees.
						operation.displayAllReferees();
						break;

					case 5:// List all papers that have not been assigned to at
							// least two referees.
						operation.displayPapers();
						break;

					case 6: // Record Assignment of a Paper
						operation.assignPaperToAReferee();
						break;

					case 7: // Record Referee report
						operation.recordRefereeReport();
						break;

					case 8: // Get list of all papers that have not received a
							// report after 4weeks
						operation.papersPendingReports();
						break;

					case 9: // Record that a reminder is sent to a referee
						operation.recordReminderSent();
						break;

					case 10: // Making a Transaction
						operation.displayPapersWith2Reports();
						break;

					case 11: // Getting all transaction details against CC
								// Number
						operation.recordCommiteeDecision();
						break;

					case 12: // Exiting Application
						System.out
								.println("Exiting Application! \n Thank You !!");
						System.exit(0);

					default: // Kept for Invalid options
						System.out.println("Invalid Entry, Please try Again\n");
					}
				} else {
					System.out.println("Invalid Input provided..");
				}
			} catch (Exception e) {
				System.out.println("Invalid Input provided..");
			}
		}
	}

	private static void printWelcomeDetails() {
		System.out.println("\nPlease choose an option to use the system: ");
		System.out
				.println("==============================================================");
		System.out.println("   1. Add a Referee.");
		System.out.println("   2. Remove a Referee.");
		System.out.println("   3. Record submission of a paper");
		System.out.println("   4. Get list of all Referees.");
		System.out
				.println("   5. Get list of all Papers[Not been assigned to at least two referees]");
		System.out
				.println("   6. Record the assignment of a paper to a Referee.");
		System.out.println("   7. Record a Referee report.");
		System.out
				.println("   8. Get list all Papers[Which have not received a report from referee after 4 weeks of the assignment date]");
		System.out
				.println("   9. Record that a reminder is sent to a Referee.");
		System.out
				.println("  10. Get List all papers[Which have received two reports from the referees].");
		System.out
				.println("  11. Record the decision of the committee about a paper.");
		System.out.println("  12. Exit Application.");
		System.out
				.println("==============================================================\n");
		System.out.print("   Your Input: ");
	}

}
