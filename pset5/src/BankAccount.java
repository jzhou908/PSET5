public class BankAccount {
	private static long generatedAccountNumber = 100000001L;
	private double balance;
	private long account;
	private User user;
	private char status;
	BankAccount(User user, double balance, long account, char status){
		this.user = user;
		this.balance = balance;
		this.account = BankAccount.generatedAccountNumber++;
		this.status = status;
	}
	public BankAccount(String line){
		String account1 = line.substring(0,9);
		account = Long.parseLong(account1);
		int pin = Integer.parseInt(line.substring(9,13));
		String balance1 = line.substring(13, 28);
		balance = Double.parseDouble(balance1);
		String fname = line.substring(28, 48);
		String lname = line.substring(48,63);
		int dob = Integer.parseInt(line.substring(63, 71));
		String phone = line.substring(71, 81);
		String street = line.substring(81, 110);
		String city = line.substring(110, 140);
		String state = line.substring(140, 142);
		String postal = line.substring(142, 147);
		status = line.charAt(148);
		user = new User(pin, lname, fname, dob, street, city, state, postal, phone);
	}
	public double getBalance() {
		return balance;
	}
	public long getAccount() {
		return account;
	}
	public User getUser() {
		return user;
	}
	public int deposit(int amount) {
		if (amount <= 0) {
			return 0;
		} else {
			balance = balance + amount;
			return 1;
		}
	}
	public int withdraw(int amount){
		if (amount > balance) {
			return 0;
		} else if (amount <= 0) {
			return 1;
		} else {
			balance = balance - amount;
			return 2;
		}
	}
	public char getStatus() {
		return status;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public int transfer(double amount, BankAccount bankaccount) {
		if (amount > balance) {
			System.out.println("Not Enough money.");
			return 0;
		} else if (amount <= 0) {
			System.out.println("Please Transfer More Money.");
			return 1;
		} else {
			this.balance -= amount;
			balance += amount;
			return 2;
		}
	}
}