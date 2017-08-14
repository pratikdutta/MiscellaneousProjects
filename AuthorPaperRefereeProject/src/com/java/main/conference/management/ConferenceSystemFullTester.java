package com.java.main.conference.management;

import java.io.IOException;

public class ConferenceSystemFullTester {
	
	public static void main(String[] args) {

		/**
		 * Create an initial ConferenceSystem object
		 */
		ConferenceSystem sys = new ConferenceSystem();
		CommiteeManagementOperations op = sys.getOperation();
		
		/**
		 * TEST FOR USE CASE:	CREATE A REFEREE
		 * TESTING TYPE:		VALID TESTING
		 */
		op.addReferee();
		
		/**
		 * TEST FOR USE CASE:	REMOVE A REFEREE
		 * TESTING TYPE:		VALID TESTING
		 */
		op.removeReferee();
		
		/**
		 * TEST FOR USE CASE:	CREATE AUTHOR
		 * TESTING TYPE:		VALID TESTING
		 */
		Author author = null;
		try {
			author = op.createAuthor();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * TEST FOR USE CASE:	CREATE PAPER
		 * TESTING TYPE:		VALID TESTING
		 */
		try {
			op.createPaper(author);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
