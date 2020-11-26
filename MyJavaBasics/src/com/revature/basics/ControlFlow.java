package com.revature.basics;

public class ControlFlow {

	public static void main(String[] args) {
		boolean flag = false;
		
		if(flag) {
		System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		int x = 2;
		int y = 0;
		switch (x) {
		default :
			y = 6;
			break;
		case 1: 
			y = 1;
			break;
			
		case 2:
			y = 2;
			break;
			
		case 3:
			y = 3;
			break;
			
		case 4:
			y = 4;
			break;
		
		}
		
		System.out.println("y = " + y);
	}
}
