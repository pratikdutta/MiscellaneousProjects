
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApplicationHelper {
	
	private static List<Integer> ids = new ArrayList<Integer>();
//	private static List<Integer> acNos = new ArrayList<Integer>();
	
	
	public static String generateRandomIds(String appender, int rng){
		int range = rng;
		Random id = new Random();
		int intId = 0;
		if(ids.size() != 0){
			intId = id.nextInt(100);
			for (int i : ids){
				if(i == intId){
					continue;
				}else{
					intId = id.nextInt(range);
					ids.add(intId);
					break;
				}
			}
		}else{
			intId = id.nextInt(100);
			ids.add(intId);
		}
		return appender+intId;
	}
	
	
	public static AccountHolder fetchUserFromBank(String userId) {		
		List<AccountHolder> users = Bank.getBank().getAccHolders();
		if(users != null && users.size() > 0){
			for (final AccountHolder user : users){
				if (userId.equals(user.getUserId())){
					return user;
				}
			}
		}		
		return null;
	}
	
		
	public static BankAccount fetchBankAccountForUser(AccountHolder user) {
		List<BankAccount> bankAccs = Bank.getBank().getBankAccounts();
		if(bankAccs != null && bankAccs.size() > 0){
			for (BankAccount bac : bankAccs){
				if((bac.getUser().getUserId()).equals(user.getUserId())){
					return bac;
				}
			}
		}
		return null;
		
	}
	
	public static CreditCard createCreditCard() {
		CreditCard cc = new CreditCard();
		cc.setCardType("VISA");
		cc.setCardNumber(generateRandomIds("",100000));
		cc.setCvv(generateRandomIds("", 1000));
		cc.setIssueDate(new java.util.Date());
		return cc;
	}
	
	
	public static CreditCard fetchCreditCardInfo(String ccNo) {
		CreditCard card = null;
		List<CreditCard> indvCards = null;
		List<CreditCard> allCards = new ArrayList<CreditCard>();
		List<AccountHolder> accHoldrs = Bank.getBank().getAccHolders();
		if(accHoldrs != null && accHoldrs.size() > 0){
			for (AccountHolder ah : accHoldrs){
				indvCards = ah.getCreditCards();
				if(indvCards != null && indvCards.size() > 0){
					allCards.addAll(indvCards);
				}
			}
		}
		if(allCards != null && allCards.size() > 0){
			for (CreditCard cc : allCards){
				if(cc != null && (cc.getCardNumber()).equals(ccNo)){
					card = cc;
				}
			}
		}
		return card;
		
	}

}