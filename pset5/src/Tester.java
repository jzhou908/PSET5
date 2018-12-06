/**
 * This class has only one responsibility: start the ATM program!
 */

public class Tester {
	
	private Database database;
	private BankAccount bankaccount;
	
	public static void main(String[] args) {
		ATM atm = new ATM(BankAccount bankaccount);
		
	}
}