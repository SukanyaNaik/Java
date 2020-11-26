package com.revature.exceptions;

public class Driver {

	public static void main(String[] args) {

		//System.out.println("ans = " + divider(6,0));
		System.out.println("ans = " + dividerLBYL(6,0));
		System.out.println("\n");
		System.out.println("ans = " + dividerEAFP(6,0));
		
		// There are two approaches to dealing with error / exceptions.
		// 1. LBYL approach : test that an object is not null before we deal with it.
		// 2. EAFP approach : perform an operation and then respond with an exception
		//    we use try / catch block in this scenario.
	}
	
	public static int divider(int x, int y){
		int ans = 0;
		
		ans = (x/y);
		
		return ans;
	}
	
	public static int dividerLBYL(int x, int y){
		int ans = 0;
		
		if(y != 0) {
			ans = (x/y);
		} else {
			System.out.println("Can not divide by 0");
		}
		
		return ans;
	}
	
	// EAFP = Easier to Ask for Forgiveness than Permission
	public static int dividerEAFP(int x, int y){
		int ans = 0;
		
		try {
			ans = (x/y);
		} 
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		finally{
			System.out.println("Exception is being handelled....");
		}
		return ans;
	}
}
