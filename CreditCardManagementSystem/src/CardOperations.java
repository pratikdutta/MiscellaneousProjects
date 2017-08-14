import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CardOperations  implements TransactionsManagable{

	private Scanner sc;
	private AccountHolder user;

	public CardOperations(Scanner sc) {
		super();
		this.sc = sc;
	}

	@Override
	/**
	 * Creating a User
	 * returns status of user creation
	 */
	public boolean createUser() {
		String userName = "";
		String address = "";
		Integer age = null;
		System.out.println("\nWelcome to User Creation:");
		System.out.println("======================================\n");
		user = new AccountHolder();
		System.out.print("Enter Name of user:");
		userName = sc.next();
		if(userName.trim().length() !=0 ){
			user.setUserName(userName);
		}else{
			System.out.println("Invalid Name Input");
		}
		System.out.print("Enter Address of user:");
		address = sc.next();
		if(address.trim().length() !=0 ){
			user.setAddress(address);
		}else{
			System.out.println("Invalid Address Input");
		}
		System.out.print("Enter Age of user:");
		age = sc.nextInt();
		if(age != null && age.intValue() != 0){
			user.setAge(age);
		}else{
			System.out.println("Invalid Age Input");
		}
		if(user.getUserName() != "" && user.getAddress() != ""
				&& user.getAge()!= null){
			user.setUserId(ApplicationHelper.generateRandomIds("User", 100));
			System.out.println("User Created Successfully with following details:");
			System.out.println(user.toString());
			user.setBank(Bank.getBank());
			Bank.getBank().getAccHolders().add(user);
			user.setCreditCards(new ArrayList<CreditCard>());
		}			
		return (user.getUserId() == null);
	}
	
	
	@Override
	public String openAccount() {
		String userId = "";
		BankAccount ac = null;
		System.out.println("\nWelcome to Account Creation:");
		System.out.println("======================================\n");
		System.out.println("Enter User Id of the User for A/C creation: ");
		userId = sc.next();
		if(userId.trim() != ""){
			final AccountHolder user = ApplicationHelper.fetchUserFromBank(userId);
			if (user != null){
				ac = new BankAccount();
				ac.setUser(user);
				ac.setBank(Bank.getBank());
				Bank.getBank().getBankAccounts().add(ac);
				ac.setAccNumber(ApplicationHelper.generateRandomIds("Acc", 100));
				ac.setAssociatedCreditCards(new ArrayList<CreditCard>());
				ac.setOpeningDate(new java.util.Date());
				System.out.println("Bank Account created successfully with following details:");
				System.out.println(ac.toString());
			}else{
				System.out.println("Invalid UserId, Please enter valid UserId!");
			}
		}
		return null;
	}

	@Override
	public boolean closeAccount() {
		System.out.println("Closing Account is "
				+ "under construction! Please try some other option..");
		return false;
	}

	@Override
	public CreditCard addNewCreditCard() {
		String acNo = "";
		String userId = "";
		System.out.println("Welcome to CreditCards Section..");
		System.out.println("======================================\n");
		System.out.println("Enter UserId and A/C Number for Adding new CreditCard:");
		System.out.print("UserId: ");
		userId = sc.next();
		System.out.print("A/C Number: ");
		acNo = sc.next();
		if(userId.trim() != ""){
			final AccountHolder user = ApplicationHelper.fetchUserFromBank(userId);
			if(user != null){
				final BankAccount acc = ApplicationHelper.fetchBankAccountForUser(user);
				if(acc != null){
					final CreditCard cc = ApplicationHelper.createCreditCard();
					cc.setUser(user);
					cc.setBank(Bank.getBank());
					cc.setAccount(acc);
					acc.getAssociatedCreditCards().add(cc);
					cc.setTransactions(new ArrayList<CreditCardTransaction>());
					cc.setAvailableBal(new Float(100000));
					user.getCreditCards().add(cc);
					System.out.println("CreditCard added successfully with following details:");
					System.out.println(cc.toString());
				}
			}
		}else{
			System.out.println("Invalid User Name");
		}
		return null;
	}

	@Override
	public boolean deleteCreditCard() {
		System.out.println("Deleting a CreditCard is "
				+ "under construction! Please try some other option..");
		
		return false;
	}

	@Override
	public List<AccountHolder> getAllUserDetailsForBank() {
		System.out.println("All User Details For Bank is "
				+ "under construction! Please try some other option..");
		return null;
	}

	@Override
	public List<AccountHolder> getCCDetails() {
		System.out.println("Credit Card Details For Bank is "
				+ "under construction! Please try some other option..");
		return null;
	}
	
	
	@Override
	public void makeATransactionForCard() {
		String ccNo = "";
		String vendor = "";
		Float transactionAmt = null;
		CreditCardTransaction trans = null;
		System.out.println("Enter your CreditCard Number for Making a Transaction:");
		ccNo = sc.next();
		if(ccNo.trim() != ""){
			CreditCard cc = ApplicationHelper.fetchCreditCardInfo(ccNo);
			if(cc != null && cc.getUser() != null){
				final AccountHolder user = cc.getUser();
				System.out.println("Welcome, Mr/Ms. "+user.getUserName()+" [UserId: "+user.getUserId()+"]");
				System.out.println("======================================\n");
				System.out.print("Enter payment amount:");
				transactionAmt = sc.nextFloat();
				System.out.print("Enter Vendor Name:");
				vendor = sc.next();
				if(transactionAmt != null && transactionAmt < cc.getAvailableBal() 
						&& vendor.trim() != ""){
					trans = new CreditCardTransaction();
					trans.setCard(cc);
					trans.setPaymentAmt(transactionAmt);
					trans.setUser(user);
					trans.setTransactionDate(new java.util.Date());
					trans.setVendor(vendor);
					trans.setAvailableBalance(cc.getAvailableBal() - transactionAmt);
					trans.setTransactionId(ApplicationHelper.generateRandomIds("Trans", 100));
					cc.getTransactions().add(trans);
					System.out.println("Transaction Successful!!\n" +
							"Please View Trnsactions aginst CreditCard used " +
							"to get transaction details.");
				}else{
					System.out.println("Invalid Transaction Amount, Please try again!");
				}
			}
		}
		
	}

	@Override
	public void getAllTransactionsForCard() {
		String ccNo = "";
		System.out.println("Enter your CreditCard Number for Viewing all Transactions:");
		ccNo = sc.next();
		if(ccNo.trim() != ""){
			CreditCard cc = ApplicationHelper.fetchCreditCardInfo(ccNo);
			if(cc != null && cc.getUser() != null){
				final AccountHolder user = cc.getUser();
				System.out.println("Hi, Mr/Ms. "+user.getUserName()+" [UserId: "+user.getUserId()+"], Below are your Transactions: ");
				System.out.println("============================================================================\n");
				if(cc != null && cc.getTransactions() != null && cc.getTransactions().size() > 0){
					int transCount = 1;
					for (CreditCardTransaction trans : cc.getTransactions()){
						System.out.println("\nTransaction #"+transCount+" :");
						System.out.println(trans.toString());
						transCount++;
					}
					System.out.println("*************************");
				}
			}else{
				System.out.println("Credit card is not recognizable!!");
			}
		}else{
			System.out.println("Invalid Credit Card No.");
		}
	}


}