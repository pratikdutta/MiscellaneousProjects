package com.java.main.conference.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CommiteeManagementOperations implements CommiteeManagable {

	private BufferedReader reader;
	private Referee referee;
	private Author author;
	private Paper paper;

	public CommiteeManagementOperations(BufferedReader reader) {
		super();
		this.reader = reader;
	}

	@Override
	public void addReferee() {
		String name = "";
		String affil = "";
		String email = "";
		String phNo = "";
		System.out.println("\nAdd a Referee:");
		System.out.println("======================================\n");
		referee = new Referee();

		try {
			// NAME Addition
			System.out.print("Enter Name of Referee:");
			name = reader.readLine();
			if (name.trim().length() != 0) {
				referee.setRefereeName(name);
			} else {
				System.out.println("Invalid Name Input");
				referee.setRefereeName("");
			}

			// AFFILIATION Addition
			System.out.print("Enter Current Affiliation of Referee:");
			affil = reader.readLine();
			if (affil.trim().length() != 0) {
				referee.setAffiliation(affil);
			} else {
				System.out.println("Invalid Affiliation Input");
				referee.setAffiliation("");
			}

			// PHONE NUMBER Addition
			while (true) {
				System.out
						.print("Enter Phone Number of Referee[10 Digit Number]:");
				phNo = reader.readLine();
				if (phNo.trim().length() > 0 && phNo.trim().length() == 10) {
					referee.setPhoneNumber(phNo);
					break;
				} else {
					System.out.println("Invalid Phone Number Input");
					referee.setPhoneNumber("");
				}
			}
			// EMAIL Addition
			while (true) {
				System.out.print("Enter Email of Referee[Ex: abc@cd]:");
				email = reader.readLine();
				if (email.trim().length() != 0 && email.contains("@")) {
					referee.setEmail(email);
					break;
				} else {
					System.out.println("Invalid Email Input");
					referee.setEmail("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Final Referee Creation
		if (referee.getRefereeName() != "" && referee.getAffiliation() != ""
				&& referee.getPhoneNumber() != "" && referee.getEmail() != "") {
			Committee.getCommitee().getReferees().add(referee);
			referee.setPapers(new LinkedList<Paper>());
			referee.setRefereeId(ApplicationHelper.generateRandomIds("Referee",
					100));
			System.out
					.println("\nReferee Added Successfully with following details:");
			System.out.println(referee.toString());
		}
	}

	@Override
	public void removeReferee() {

		String id = "";
		System.out.println("\nRemove a Referee:");
		System.out.println("======================================\n");
		System.out.print("Enter ID of Referee for Removal:");
		try {
			id = reader.readLine();
			Referee referee = ApplicationHelper.fetchRefereeFromCommitee(id);
			if (null != referee && (!((referee.getPapers().size()) > 0))) {
				System.out.println("Attempting to Remove Referee:");
				System.out.println(referee.toString());
				System.out.print("\nPress 'Y' to continue: ");
				if ((reader.readLine()).equalsIgnoreCase("Y")) {
					Committee.getCommitee().getReferees().remove(referee);
					System.out.println("Referee Removed.");
				} else {
					System.out.println("Referee Removal Cancelled.");
				}
			} else {
				System.out
						.println("Referee Not Found Or Referee has Papers assigned to his name.");
			}

		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Unexpected Input/Output Error Occured.");
		}

	}

	@Override
	public void recordSubmissionOfAPaper() {
		String input = "";
		System.out.println("\nSubmit A Paper:");
		System.out.println("======================================\n");
		System.out
				.print("Enter ID of Author or 'N' for new Author Registration:");
		try {
			input = reader.readLine();
			if (input.equalsIgnoreCase("N")) {
				createAuthor();
			} else {
				author = ApplicationHelper.fetchAuthorFromCommitee(input);
				if (author != null) {
					System.out.println("Paper being added against author: \n"
							+ author.toString());
					createPaper(author);
				} else {
					System.out.println("Author Not Found.");
				}
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Unexpected Input/Output Error Occured.");
		}

	}

	protected Author createAuthor() throws IOException {
		String input;
		author = new Author();

		// NAME INPUT
		System.out.print("Enter name of Author:");
		input = reader.readLine();
		if (input != null && input.length() != 0) {
			author.setUserName(input);
		} else {
			System.out.println("Invalid Name Input");
			author.setUserName("");
		}

		// AFFILIATION INPUT
		System.out.print("Enter affiliation of Author:");
		input = reader.readLine();
		if (input != null && input.length() != 0) {
			author.setAffiliation(input);
		} else {
			System.out.println("Invalid Affiliation Input");
			author.setAffiliation("");
		}

		// PHONE NO INPUT
		while (true) {
			System.out.print("Enter Phone Number of Author[10 Digit Number]:");
			input = reader.readLine();
			if (input != null && input.length() == 10) {
				author.setPhoneNumber(input);
				break;
			} else {
				System.out.println("Invalid Phone Number Input");
				author.setPhoneNumber("");
			}
		}

		// EMAIL Input
		while (true) {
			System.out.print("Enter Email of Author[Ex: abc@cd]:");
			input = reader.readLine();
			if (input.trim().length() != 0 && input.contains("@")) {
				author.setEmail(input);
				break;
			} else {
				System.out.println("Invalid Email Input");
				author.setEmail("");
			}
		}

		// Final AUTHOR Creation
		if (author.getUserName() != "" && author.getAffiliation() != ""
				&& author.getPhoneNumber() != "" && author.getEmail() != "") {
			Committee.getCommitee().getAuthors().add(author);
			author.setPapers(new LinkedList<Paper>());
			author.setUserId(ApplicationHelper.generateRandomIds("Author", 100));
			System.out
					.println("\nAuthor Registered Successfully with following details:");
			System.out.println(author.toString());
			System.out.println("======================================\n");
			createPaper(author);
		} else {
			System.out.println("Author Registration failed!");
			author = null;
		}

		return this.author;
	}

	protected void createPaper(Author author) throws IOException {
		String input;
		System.out.println("\nEnter details of the Paper:");
		System.out.println("======================================\n");
		paper = new Paper();
		System.out.println("Enter Name of Paper:");
		input = reader.readLine();
		if (input != null && input.trim().length() != 0) {
			paper.setName(input);
		} else {
			System.out.println("Invalid Name Input");
			paper.setName("");
		}
		System.out.println("Enter Description of Paper:");
		input = reader.readLine();
		if (input != null && input.trim().length() != 0) {
			paper.setDescription(input);
		} else {
			System.out.println("Invalid Description Input");
			paper.setDescription("--");
		}

		System.out
				.println("Enter Length of Paper['R' for REGULAR, 'S' for SHORT]:");
		input = reader.readLine();
		if (input != null && input.trim().length() != 0
				&& (input.equalsIgnoreCase("R") || input.equalsIgnoreCase("S"))) {
			paper.setSize((input.equalsIgnoreCase("R")) ? Paper.PaperSize.REGULAR
					: Paper.PaperSize.SHORT);
		} else {
			System.out.println("Invalid Paper Size Input");
			paper.setSize(null);
		}

		// Final PAPER Creation
		if (paper.getName() != "" && paper.getSize() != null) {
			Committee.getCommitee().getPapers().add(paper);
			author.getPapers().add(paper);
			paper.setReferees(new LinkedList<Referee>());
			paper.setPaperId(ApplicationHelper.generateRandomIds("Paper", 100));
			System.out
					.println("\nPaper Added Successfully with following details:");
			System.out.println(paper.toString());
			System.out.println("======================================\n");
		} else {
			System.out.println("Paper creation failed!");
			paper = null;
		}
	}

	@Override
	public void displayAllReferees() {
		int i = 1;
		System.out.println("Below are details of all the Referees:");
		System.out.println("======================================\n");
		List<Referee> referees = Committee.getCommitee().getReferees();
		if (referees != null && referees.size() > 0) {
			for (Referee ref : referees) {
				System.out.println("Referee # " + i);
				System.out.println(ref.toString());
				System.out.println("--------------------");
				i++;
			}
		}
	}

	@Override
	/**
	 * List of all papers that have not been assigned to at least two referees.
	 */
	public void displayPapers() {
		int i = 1;
		System.out
				.println("Below are details of all the Papers NOT referred to at least 2 referees:");
		System.out
				.println("============================================================================\n");
		List<Paper> papers = Committee.getCommitee().getPapers();
		if (papers != null && papers.size() > 0) {
			for (Paper paper : papers) {
				if (paper.getReferees().size() < 2) {
					System.out.println("Paper # " + i);
					System.out.println(paper.toString());
					System.out.println("--------------------");
					i++;
				}
			}
		}

	}

	@Override
	public void assignPaperToAReferee() {
		String input = "";
		Paper paper = null;
		Referee referee = null;
		System.out.println("\nAssign a Paper to a Referee:");
		System.out.println("======================================\n");
		System.out.print("Enter Paper Id or 'N' for NEW Paper Addition :");
		try {
			input = reader.readLine();
			if (input != "" && input.equalsIgnoreCase("N")) {
				recordSubmissionOfAPaper();
			} else {
				paper = ApplicationHelper.fetchPaperFromCommitee(input);
				if (paper != null) {
					this.paper = paper;
					System.out.println("Paper details: \n" + paper.toString());
				}
			}

			System.out
					.print("Enter Referee Id or 'N' for NEW Referee Addition :");
			input = reader.readLine();
			if (input != "" && input.equalsIgnoreCase("N")) {
				addReferee();
			} else {
				referee = ApplicationHelper.fetchRefereeFromCommitee(input);
				if (referee != null) {
					this.referee = referee;
					System.out.println("Referee details: \n"
							+ referee.toString());
				}
			}

			System.out.print("Enter 'Y' to continue Referring:");
			input = reader.readLine();
			if (input != "" && input.equalsIgnoreCase("Y")) {
				if (referee.getPapers().size() < 5) {
					this.referee.getPapers().add(paper);
					paper.getReferees().add(referee);
					paper.setAssignmentId(ApplicationHelper.generateRandomIds(
							"Assign", 100));
					System.out
							.print("Referred Successfully with Assignment ID: "
									+ paper.getAssignmentId());
				} else {
					System.out
							.println("No More Papers Can Be Assigned To Referee: "
									+ referee.getRefereeName());
				}
			} else {
				System.out.println("Paper Assignment Cancelled");
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Unexpected Input/Output Error Occured.");
		}

	}

	@Override
	public void recordRefereeReport() {
		String input = "";
		Referee referee = null;
		Paper paper = null;
		System.out.println("\nRecord A Referee Report");
		System.out.println("======================================\n");
		System.out.print("Enter Paper Id or 'N' for NEW Paper Addition :");
		try {
			input = reader.readLine();
			if (input != "" && input.equalsIgnoreCase("N")) {
				recordSubmissionOfAPaper();
			} else {
				paper = ApplicationHelper.fetchPaperFromCommitee(input);
				if (paper == null) {
					paper = ApplicationHelper.fetchPaperFromPaperRepo(input);
				}
				if (paper != null) {
					this.paper = paper;
					System.out.println("Paper details: \n" + paper.toString());
				}
			}

			System.out
					.print("Enter Referee Id or 'N' for NEW Referee Addition :");
			input = reader.readLine();
			if (input != "" && input.equalsIgnoreCase("N")) {
				addReferee();
			} else {
				referee = ApplicationHelper.fetchRefereeFromCommitee(input);
				if (referee != null) {
					this.referee = referee;
					System.out.println("Referee details: \n"
							+ referee.toString());
				}
			}

			System.out.print("Enter 'Y' to continue Recording:");
			input = reader.readLine();
			if (input != "" && input.equalsIgnoreCase("Y")) {
				System.out
						.println("Enter Coments['1' for Accepting without changes, "
								+ "'2' for Accepting with changes, '3' for Rejecting]");

				input = reader.readLine();
				if (input.trim() != "") {
					Integer oprtnInput = null;
					try {
						oprtnInput = Integer.parseInt(input);
					} catch (NumberFormatException nfe) {
						oprtnInput = 50; // Abitrary value for invalid inputs.
					}
					if (!Double.isNaN(oprtnInput)) {
						switch (oprtnInput) {
						case 1:
							paper.setReport(Paper.Report.ACCEPT_WITHOUT_CHANGES);
							break;
						case 2:
							paper.setReport(Paper.Report.ACCEPT_WITH_CHANGES);
							break;
						case 3:
							paper.setReport(Paper.Report.REJECT);
							break;
						default:
							System.out
									.println("Invalid Entry, Please try Again\n");
						}
					}
				}

				paper.setReportSubmissionDate(new java.util.Date());
				paper.setReportReceived(true);
				if (!((Committee.getCommitee().getRepo().getPapers())
						.contains(paper))) {
					Committee.getCommitee().getRepo().getPapers().add(paper);
					Committee.getCommitee().getPapers().remove(paper);
				}
				System.out.println(paper.getName() + " has received report: "
						+ paper.getReport() + " on "
						+ paper.getReportSubmissionDate());
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Unexpected Error Occured.");
		}
	}

	@Override
	public void papersPendingReports() {
		System.out.println("Under Construction");
	}

	@Override
	public void recordReminderSent() {
		String input = "";
		Paper paper = null;
		Referee referee = null;
		System.out.println("\nSend Reminder To Referee.");
		System.out.println("======================================\n");
		try {
			System.out.print("Enter Paper Id :");
			input = reader.readLine();
			paper = ApplicationHelper.fetchPaperFromPaperRepo(input);
			if (paper != null) {
				this.paper = paper;
				System.out.println("Paper Details Obtained: ");
				System.out.println(paper.toString());
			} else {
				System.out.println("Paper not found. Please try again.");
			}
			System.out.print("Enter Referee Id :");
			input = reader.readLine();
			if (input.trim() != "") {
				referee = ApplicationHelper.fetchRefereeFromCommitee(input);
				if (referee != null) {
					this.referee = referee;
					if ((referee.getPapers()).contains(paper)) {
						System.out.println("Referee Details Obtained: \n"
								+ referee.toString());
						System.out.print("Enter 'Y' to continue Referring:");
						input = reader.readLine();
						if (input != "" && input.equalsIgnoreCase("Y")) {
							paper.setRemindersReceived(paper
									.getRemindersReceived() + 1);
							referee.setRemindersReceived(referee
									.getRemindersReceived() + 1);
							System.out.println("Reminder sent Successfully.");
						} else {
							System.out.println("Sending Reminder Cancelled");
						}
					} else {
						System.out
								.println("Paper and Referee combinations do not match.");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Unexpected Input/Output Error Occured.");
			e.printStackTrace();
		}

	}

	@Override
	public void displayPapersWith2Reports() {
		System.out.println("Under Construction");
	}

	@Override
	public void recordCommiteeDecision() {
		String input = "";
		Paper paper = null;
		System.out.println("\nRecord Decision Of The Commitee.");
		System.out.println("======================================\n");
		try {
			System.out.print("Enter Paper Id :");
			input = reader.readLine();
			paper = ApplicationHelper.fetchPaperFromPaperRepo(input);
			if (paper == null) {
				paper = ApplicationHelper.fetchPaperFromCommitee(input);
			}
			if (paper != null) {
				this.paper = paper;
				System.out.println("Enter Commitee decision: ");
				input = reader.readLine();
				if (input.trim() != "") {
					paper.setDecision(input);
					System.out.println("Final decision on the paper with Id: "
							+ paper.getPaperId() + " has been taken.");
				} else {
					System.out.println("Please enter valid comments!");
				}
			} else {
				System.out.println("Paper not found. Please try again.");
			}
		} catch (Exception e) {
			System.out.println("Unexpected Input/Output Error Occured.");
			e.printStackTrace();
		}
	}

}
