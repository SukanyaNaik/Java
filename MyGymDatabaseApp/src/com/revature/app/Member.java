package com.revature.app;

import java.util.Scanner;

public class Member {
	private String firstName;
	private String lastName;
	private String tear; //A for 65+ yrs old, B for >= 18 yrs old, C for < 18
	private String memberId; // A unique combo of tear & incremented id
	private String enrolledClasses = "";
	private double monthlyDues = 0;
	
	private static final double costOfClasses = 100;
	private static int id = 1000; // the value of this increases everytime we add a new member
	
	public Member() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your First Name :- ");
		this.firstName = scan.nextLine();
		
		System.out.println("Enter your Last Name :- ");
		this.lastName = scan.nextLine();
		
		System.out.println("Enter your Age :- ");
		int age = scan.nextInt();
		
		if(age >= 65) {
			this.tear = "A";
		}
		else if(age >= 18) {
			this.tear = "B";
		}
		else {
			this.tear = "C";
		}
		
		setMemberId();
		scan.close();
	}
	
	// 1. Method to generate an Id
	private void setMemberId() {
		id++;
		this.memberId = this.tear + id;
	}

	// 2. Method to enroll in classes
	
	public void enroll() {
		Scanner scan = new Scanner(System.in);
		boolean asking = true;
		
		do {
			System.out.println("Enter the exercise class to enroll in (Q to quit):- ");
			String classToEnrollIn = scan.nextLine();
			
			if(!this.enrolledClasses.equals("Q")) {
				this.enrolledClasses += "\n" + classToEnrollIn;
				this.monthlyDues += costOfClasses;
			}
			else {
				asking = false;
			}
			
		}while(asking);
		
		scan.close();
	}
	
	// 3. Method to pay monthly dues
	
	// 4. Method to view account information
	
	@Override
	public String toString() {
		return "Member [firstName=" + firstName + ", lastName=" + lastName + ", tear=" + tear + ", memberId=" + memberId
				+ ", monthlyDues=" + monthlyDues + "]";
	}
}
