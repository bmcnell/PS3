package PrS3.src;

import java.util.Date;

public class Account {
	
	//variable declaration
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	
	//new Date type
	private Date dateCreated;
	
	//no arg constructor
	public Account() {
	}
	
	//two arg constructor
	public Account(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	//setters and getters for each primitive
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	//getter for dateCreated
	public Date getDateCreated() {
		return dateCreated;
	}
	
	//for monthly interest, divide by 12mo
	public double getMonthlyInterestRate()  {
		double monthlyIR = annualInterestRate/12;
		return monthlyIR;
	}
	
	//deposit method, adds to balance
	public double deposit(double amount) {
		return balance += amount;
	}
	
	//withdraw method, throws exception for insufficient funds
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount <= balance) {
			balance -= amount;
		}
		else {
			double neededFunds = amount - balance;
			throw new InsufficientFundsException(neededFunds);
		}
	}
}