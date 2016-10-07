package PrS3.src;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	@Test
	public void test() {
		//creating new account, with new id, balance, interest rate, and deposit amount
		// - - withdraw amount used later to test exception
		Account newAcct = new Account(1122, 20000);
		
		newAcct.setAnnualInterestRate(4.5);
		newAcct.deposit(3000);
		
		System.out.printf("The account's current balance is $%.2f", newAcct.getBalance());
		System.out.printf("\nThe account's monthly interest rate is %.2f%%", newAcct.getMonthlyInterestRate());
		System.out.println("\nThe account was created on " + newAcct.getDateCreated());	
		
		//try-catch that should NOT throw exception
		try {
			newAcct.withdraw(2500);
			System.out.println("$2500 has been withdrawn.");
		} catch (InsufficientFundsException e) {
			System.out.println("InsufficientFunds - not enough money in the account to withdraw.");
		}
		
		//try-catch that SHOULD throw exception
		try {
			newAcct.withdraw(70000000);
			System.out.println("$70000000 has been withdrawn.");
		} catch (InsufficientFundsException e) {
			System.out.println("InsufficientFunds - not enough money in the account to withdraw $70000000.");
		}
		
	}	
}
