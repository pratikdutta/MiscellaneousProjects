import java.util.Scanner;


public class CreditCardsManagement{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in) ;
		CardOperations operation = new CardOperations(sc);
		
		System.out.println("Welcome to the CreditCard Management System For National Global Bank Ltd");
		System.out.println("===============================================================================\n");
		
		while  
			(true) {
			printWelcomeDetails();
			try{
				String inpStr = sc.next() ;
				Integer oprtnInput = null;
				try{
					oprtnInput = Integer.parseInt(inpStr);
				}catch (NumberFormatException nfe) {
					oprtnInput = 50; // Abitrary value for invalid inputs.
				}
				if(!Double.isNaN(oprtnInput)){
					switch  (oprtnInput) {
					
					case 1:// Create a user : the first step
						operation.createUser () ;
						break ;
						
						
					case 2: // Opening a bank account:  The 2nd step
						operation.openAccount () ;
						break ;
						
						
					case 3: // Closing a bank account: Optionally kept for further enhancements
						operation.closeAccount () ;
						break ;
						
						
					case 4: // Adding a new CreditCard against a user's bank account
						operation.addNewCreditCard () ;
						break ;
						
						
					case 5:// Deleting a CreditCard against CC number
						operation.deleteCreditCard () ;
						break ;
						
						
					case 6: // Fetching all details about a certain user
						operation.getAllUserDetailsForBank () ;
						break ;
						
						
					case 7: // Fetching Details of CC against CC number
						operation.getCCDetails() ;
						break ;
						
						
					case 8: // Making a Transaction
						operation.makeATransactionForCard () ;
						break ;
						
						
					case 9: // Getting all transaction details against CC Number
						operation.getAllTransactionsForCard () ;
						break ;
						
						
					case 0: // Exiting Application
						System.out.println ("Exiting Application! \n Thank You !!") ;
						System.exit (0) ;
						
						
					default: // Kept for Invalid options
						System.out.println ("Invalid Entry, Please try Again\n") ;
					
				}
			}else{
				System.out.println("Invalid Input provided..");
			}
			}catch(Exception e){
				System.out.println("Invalid Input provided..");
			}
		}
	}
	
	
	private static void printWelcomeDetails(){
		System.out.println("\nPlease choose an option to use the system: ");
		System.out.println("==============================================================");
		System.out.println("   1. Create A User.");
		System.out.println("   2. Open a Bank Account.");
		System.out.println("   3. Close a Bank Account.");
		System.out.println("   4. Add CreditCard for a user");
		System.out.println("   5. Delete CreditCard for a user.");
		System.out.println("   6. Display Single/Multiple User details.");
		System.out.println("   7. Display Single/Multiple card details");
		System.out.println("   8. Make a Transaction.");
		System.out.println("   9. Display cc transactions.");
		System.out.println("   0. Exit.") ;
		System.out.println("******  PLEASE DO NOT ENTER BLANK SPACES WITHIN NAME/ADDRESS FIELDS  ******");
		System.out.println("==============================================================\n");
		System.out.print("   Your Input: ") ;
	}

}