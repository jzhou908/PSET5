import java.io.*;
/**
 * This class has only one responsibility: start the ATM program!
 */

public class Tester {
	
	public static void main(String[] args) throws IOException {
		ATM atm = new ATM();
		do {
			atm.menu1();
		}while(atm.again());
		do {
			atm.menu2();
		}while(atm.again());
	}
}
