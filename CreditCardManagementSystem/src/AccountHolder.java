import java.util.List;


public class AccountHolder {
	
	private String userName;
	private String userId;
	// Password Field has not been included to keep the application simple
	private Integer age;
	private String address;
	private Bank bank;
	private List<CreditCard> creditCards;
	
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName.toUpperCase();
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address.toUpperCase();
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}
	
	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@Override
	public String toString() {
		return " UserName: " + userName + ",\n User Id: " + userId
				+ ",\n User Age: " + age + ",\n Address: " + address;
	}
	
	
}