import java.util.ArrayList;
import java.util.List;


public class Bank {
	
	private String bankName;
	private String bankBranch;
	private List<AccountHolder> accHolders;
	private List<BankAccount> bankAccounts;
	
	private static Bank bank = new Bank();
	
	private Bank(){
		this.bankName = "National";
		this.bankBranch = "Global";
		this.accHolders = new ArrayList<AccountHolder>();
		this.bankAccounts = new ArrayList<BankAccount>();
	}
	
	public static Bank getBank(){
		return bank;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public List<AccountHolder> getAccHolders() {
		return accHolders;
	}
	public void setAccHolders(List<AccountHolder> accHolders) {
		this.accHolders = accHolders;
	}
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	


	@Override
	public String toString() {
		return "\nBank Details:\n  BankName: " + bankName + ",\n  BankBranch:" + bankBranch + ".";
	}

	
	
}