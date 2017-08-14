import java.util.List;


public interface TransactionsManagable {
	
	
	/**
	 * Take the bank name and return the created account number
	 */
	public boolean createUser();
	
	/**
	 * Take the bank name and return the created account number
	 */
	public String openAccount();
	
	/**
	 * Take the bank name and Account number and return closure status
	 */
	public boolean closeAccount();
	
	
	/**
	 * Add a new CC and return it
	 */
	public CreditCard addNewCreditCard();
	
	/**
	 * 
	 * @param bank
	 * @param card
	 * @return Delete a CC and return deletion status
	 */
	public boolean deleteCreditCard();
	

	/**
	 * 
	 * @param bank
	 * @return Return all the details of all AccountHolders for a particular bank
	 */
	public List<AccountHolder> getAllUserDetailsForBank();

	
	/**
	 * 
	 * @param bank
	 * @return Return all the details of all CCs for a particular bank
	 */
	public List<AccountHolder> getCCDetails();
	
	
	/**
	 * 
	 * @param bank
	 * @return Return all the details of all CCs for a particular bank
	 */
	public void makeATransactionForCard();
	
	
	/**
	 * 
	 * @param bank
	 * @param ccNumber
	 * @return
	 */
	public void getAllTransactionsForCard();
}