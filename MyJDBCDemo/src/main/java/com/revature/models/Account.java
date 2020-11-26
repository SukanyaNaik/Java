package com.revature.models;

public class Account {
	
	private int accountNo;
	private String firstName;
	private String lastName;
	private int balance;
	
	public Account() {
		
	}
	
	// we create getter and setter methods to define properties

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	

	// Generate a toString() method;

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", firstName=" + firstName + ", lastName=" + lastName + ", balance="
				+ balance + "]";
	}	

	
}
