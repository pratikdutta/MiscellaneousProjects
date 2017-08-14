import java.util.Date;


public class CreditCardTransaction {
	
	private CreditCard card;
	private AccountHolder user;
	private Date transactionDate;
	private Float availableBalance;
	private String vendor;
	private Float paymentAmt;
	private String transactionId;
	
	
	/**
	 * @return the card
	 */
	public CreditCard getCard() {
		return card;
	}
	/**
	 * @param card the card to set
	 */
	public void setCard(CreditCard card) {
		this.card = card;
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
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	/**
	 * @return the availableBalance
	 */
	public Float getAvailableBalance() {
		return availableBalance;
	}
	/**
	 * @param availableBalance the availableBalance to set
	 */
	public void setAvailableBalance(Float availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor.toUpperCase();
	}
	public Float getPaymentAmt() {
		return paymentAmt;
	}
	public void setPaymentAmt(Float paymentAmt) {
		this.paymentAmt = paymentAmt;
	}
	
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((availableBalance == null) ? 0 : availableBalance.hashCode());
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result
				+ ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CreditCardTransaction))
			return false;
		CreditCardTransaction other = (CreditCardTransaction) obj;
		if (availableBalance == null) {
			if (other.availableBalance != null)
				return false;
		} else if (!availableBalance.equals(other.availableBalance))
			return false;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
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
		return "Card:\n" + card.printForTransactions() 
				+ ",\n Transaction Date: " + transactionDate 
				+ ",\n AvailableBalance: " + availableBalance
				+ ",\n Vendor=" + vendor 
				+ ",\n Paid Amountt=" + paymentAmt
				+ ",\n TransactionId=" + transactionId;
	}
	
	
}