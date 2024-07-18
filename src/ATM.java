import java.util.ArrayList;

public class ATM {
	private String creditCardNumber;
	private double balance;
	private boolean isAuthorized;
	private boolean sufficient;
	ArrayList<Transaction> history = new ArrayList<Transaction>();
	int currentTransactionIndex = -1;
	
	public ATM(String creditCardNumber) {
          if(!creditCardNumber.equals("5483")) {
			isAuthorized = false;
		}
		else {
			isAuthorized = true;
			this.creditCardNumber = creditCardNumber;
		}		
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	
	public boolean authorize() {
		return isAuthorized;
	}
	
	public double getBalance() {
		return balance;
	}
	
	
	public boolean withdraw(double amount) {
		if(amount <= balance) {
			sufficient = true;
			balance-=amount;
			history.add(new Transaction("Withdraw", amount));
			currentTransactionIndex = history.size() - 1;
			return true;
		}
		else
			sufficient = false;
		return false;
		
	}
	
	public void deposit(double amount) {
		balance += amount;
		history.add(new Transaction("Deposit", amount));
		currentTransactionIndex = history.size() - 1;
	}
	
	
	public Transaction getCurrentTransaction() {
		  return history.get(currentTransactionIndex);
	}
	
	public void previous() {
		if (currentTransactionIndex >  history.size() - 5 && currentTransactionIndex > 0) {
			currentTransactionIndex--;
		}
	}
	
	public void next() {
		if (currentTransactionIndex < history.size() - 1) {
			currentTransactionIndex++;
		}
	}
}
