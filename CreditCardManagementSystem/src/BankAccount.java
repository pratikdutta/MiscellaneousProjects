import java.util.Date;
import java.util.List;


public class BankAccount {
	
	private Bank bank;
	private String accNumber;
	private AccountHolder user;
	private Date openingDate;
	private List<CreditCard> associatedCreditCards;
	
	
	/**
	 * @return the bank
	 */
	public Bank getBank() {
		return bank;
	}
	
	
	/**
	 * @param bank the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
	/**
	 * @return the accNumber
	 */
	public String getAccNumber() {
		return accNumber;
	}


	/**
	 * @param accNumber the accNumber to set
	 */
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}


	/**
	 * @return the user
	 */
	public AccountHolder getUser() {
		return user;
	}
	
	
	/**
	 * @param user the user to set
	 */
	public void setUser(AccountHolder user) {
		this.user = user;
	}
	
	
	/**
	 * @return the openingDate
	 */
	public Date getOpeningDate() {
		return openingDate;
	}
	
	
	/**
	 * @param openingDate the openingDate to set
	 */
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	
	
	/**
	 * @return the associatedCreditCards
	 */
	public List<CreditCard> getAssociatedCreditCards() {
		return associatedCreditCards;
	}
	
	
	/**
	 * @param associatedCreditCards the associatedCreditCards to set
	 */
	public void setAssociatedCreditCards(List<CreditCard> associatedCreditCards) {
		this.associatedCreditCards = associatedCreditCards;
	}


	@Override
	public String toString() {
		return "\n Bank Account Number: " + accNumber +"\n"+ user.toString()
				+ ",\n OpeningDate:" + openingDate + Bank.getBank().toString();
	}	
	
	
}