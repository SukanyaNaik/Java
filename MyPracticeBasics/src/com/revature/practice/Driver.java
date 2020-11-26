package com.revature.practice;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Enter your name - ");
			
			String name = scanner.nextLine();
			
			System.out.print("My name is - " + name + "\n");
			
			System.out.println("Enter your age - ");
			
			int age = scanner.nextInt();
			
			System.out.println("I am " + age + " years old.");
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		scanner.close();
	}

}
