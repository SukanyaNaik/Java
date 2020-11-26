package com.revature.app;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 100;
		int y = 50;
		System.out.println("Sum = " + adder(100,50));
		System.out.println("Difference = " + subtractor(100,50));
	}

	public static int adder(int x, int y) {
		return (x + y);
	}
	
	public static int subtractor(int x, int y) {
		return (x - y);
	}
}
