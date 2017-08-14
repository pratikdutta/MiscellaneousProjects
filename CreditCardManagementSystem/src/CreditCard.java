import java.util.Date;
import java.util.List;


public class CreditCard {

	private AccountHolder user;
	private Bank bank;
	private BankAccount account;
	private String cardType;
	private String cardNumber;
	private String cvv;
	private Date issueDate;
	private Date expDate;
	private List<CreditCardTransaction> transactions;
	private Float availableBal;
	
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
	 * @return the account
	 */
	public BankAccount getAccount() {
		return account;
	}
	
	
	/**
	 * @param account the account to set
	 */
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	
	
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	
	
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	/**
	 * @return the cvv
	 */
	public String getCvv() {
		return cvv;
	}
	
	
	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
	/**
	 * @return the issueDate
	 */
	public Date getIssueDate() {
		return issueDate;
	}
	
	
	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	
	/**
	 * @return the expDate
	 */
	public Date getExpDate() {
		return expDate;
	}
	
	
	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	
	/**
	 * @return the transactions
	 */
	public List<CreditCardTransaction> getTransactions() {
		return transactions;
	}
	
	
	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(List<CreditCardTransaction> transactions) {
		this.transactions = transactions;
	}


	/**
	 * @return the availableBal
	 */
	public Float getAvailableBal() {
		return availableBal;
	}


	/**
	 * @param availableBal the availableBal to set
	 */
	public void setAvailableBal(Float availableBal) {
		this.availableBal = availableBal;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		result = prime * result
				+ ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result
				+ ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
		result = prime * result + ((expDate == null) ? 0 : expDate.hashCode());
		result = prime * result
				+ ((issueDate == null) ? 0 : issueDate.hashCode());
		result = prime * result
				+ ((transactions == null) ? 0 : transactions.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CreditCard))
			return false;
		CreditCard other = (CreditCard) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (cvv == null) {
			if (other.cvv != null)
				return false;
		} else if (!cvv.equals(other.cvv))
			return false;
		if (expDate == null) {
			if (other.expDate != null)
				return false;
		} else if (!expDate.equals(other.expDate))
			return false;
		if (issueDate == null) {
			if (other.issueDate != null)
				return false;
		} else if (!issueDate.equals(other.issueDate))
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CreditCard Number: "+ cardNumber + ",\n CardType: " + cardType 
				+ ",\n CVV: " + cvv + ",\n IssueDate: " + issueDate + ",\n User: \n" + user.toString() 
				+ bank + ",\n Account: "+ account;
	}	
	
	public String printForTransactions() {
		return "CreditCard Number: "+ cardNumber + ",\n CardType: " + cardType + bank;		
	}
	
	
}