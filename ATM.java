import java.util.Scanner;
import java.io.*;

public class ATM { 
	static Scanner in = new Scanner(System.in);
	BankAccount bankaccount;
	private Database database;
	
	ATM(BankAccount bankaccount){
		this.bankaccount = bankaccount;
	}
	public void menu1() throws IOException {
		System.out.println("What would you like to do?");
		System.out.println("1. Create Account");
		System.out.println("2. Login");
		System.out.println("3. Quit");
		boolean check = true;
		do {
			int a = in.nextInt();
			in.nextLine();
			if(a == 1) {
				System.out.println("What is your PIN?");
				int pin = in.nextInt();
				in.nextLine();
				System.out.println("What is your First name?");
				String fname = in.nextLine();
				System.out.println("What is your Last Name?");
				String lname = in.nextLine();
				System.out.println("What is your date of birth?(yyyymmdd)");
				int dob = in.nextInt();
				in.nextLine();
				System.out.println("What is your Street?");
				String street = in.nextLine();
				System.out.println("What is your city?");
				String city = in.nextLine();
				System.out.println("What is your state?");
				String state = in.nextLine();
				System.out.println("What is your postal code?");
				String postal = in.nextLine();
				System.out.println("What is your Phone?");
				String phone = in.nextLine();
				User user = new User(pin, fname,lname, dob, street, city, state, postal, phone);
				BankAccount bankaccount = new BankAccount(user, 0.00, database.getMaxAccountNumber()+1, 'Y');
				database.updateAccount(bankaccount, null);
				check = false;
			}
			else if(a == 2) {
				System.out.println("What is your account number?");
				long acc = in.nextLong();
				System.out.println("What is your pin?");
				int pin = in.nextInt();
				in.nextLine();
				if(pin == this.bankaccount.getUser().getPin() && acc == this.bankaccount.getAccount()) {
					this.menu2();
				}
				check = false;
			}
			else if(a == 3) {
				System.out.println("Thank you for using this ATM.");
				check = false;
			}
			else {
				System.out.println("Sorry wrong input, try again.");
				check = true;
			}
		}while(check);
	}
	public void menu2() throws IOException{
		System.out.println("What would you like to do?");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Check Balance");
		System.out.println("4. Update Information");
		System.out.println("5. Tranfer");
		System.out.println("6. View Account Information");
		System.out.println("7. Close Account");
		System.out.println("8. Logout");
		int a = in.nextInt();
		if(a == 1) {
			System.out.println("How much would you like to deposit?");
			int b = in.nextInt();
			this.bankaccount.deposit(b);
			System.out.println("Transaction Complete");
		}
		else if(a == 2) {
			System.out.println("How much would you like to withdraw?");
			int b = in.nextInt();
			this.bankaccount.withdraw(b);
			System.out.println("Transaction Complete");
		}
		else if(a == 3){
			System.out.print("This is your current balance: ");
			System.out.println("$" + this.bankaccount.getBalance());
		}
		else if(a == 4) {
			System.out.println("What would you like to update? (1 for phone, 2 for address, 3 for PIN)");
			int x = in.nextInt();
			in.nextLine();
			switch(x) {
			case 1 :
				System.out.println("What is your new Phone Number?");
				this.bankaccount.getUser().setPhone(in.nextLine());
			case 2 :
				System.out.println("What is your new address?");
				System.out.println("Street Address: ");
				this.bankaccount.getUser().setStreet(in.nextLine());
				System.out.println("State: ");
				this.bankaccount.getUser().setState(in.nextLine());
				System.out.println("City: ");
				this.bankaccount.getUser().setCity(in.nextLine());
				System.out.println("Postal: ");
				this.bankaccount.getUser().setPostal(in.nextLine());
			case 3 :
				System.out.println("What is your current PIN?");
				int pin = in.nextInt();
				in.nextLine();
				if(pin == this.bankaccount.getUser().getPin()) {
					System.out.println("What is your new score?");
					this.bankaccount.getUser().setPin(in.nextInt());
				}
			}
		}
		else if(a == 5) {
			System.out.println("How much would you like to transfer?");
			double x = in.nextDouble();
			System.out.println("What account would you like to transfer to?");
			long accountnumber = in.nextLong();
			in.nextLine();
			switch (this.bankaccount.transfer(x, database.getAccount(accountnumber))) {
				case 0: System.out.println("Cannot transfer more than balance.");
				case 1: System.out.println("Cannot transfer a negative amount.");
				case 2: System.out.println("Transfer Complete.");
			}
		}
		else if(a == 6) {
			System.out.println("Name :" + this.bankaccount.getUser().getLname() + ", " + this.bankaccount.getUser().getFname());
			System.out.println("Date of Birth: " + this.bankaccount.getUser().getDob());
			System.out.println("Address: " + this.bankaccount.getUser().getStreet() + ", " + this.bankaccount.getUser().getCity() + ", " + this.bankaccount.getUser().getState() + ", " + this.bankaccount.getUser().getPostal());
			System.out.println("Phone: " + this.bankaccount.getUser().getPhone());
		}
		else if(a == 7) {
			this.bankaccount.setStatus('N');
		}
		else if(a == 8) {
			if(again()) {
				menu1();
			}
			else {
				System.out.println("Have a nice day.");
			}
		}
		else {
			System.out.println("Incorrect input, try again.");
		}
	}
	public boolean again() {
		System.out.println("Do you want to use another account? (1 for yes/2 for no)");
		int answer = in.nextInt();
		in.nextLine();
		if(answer == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
