package com.revature.continuedbasics;

public class ForLoops {

	public static void main(String[] args) {
		
		int[] values = new int[100];
		
		/*for(int i = 0; i < 100; i++) {
			values[i] = i+1;
			System.out.println("Values[" + (i+1) + "] = " + values[i]);
		}*/
		
		System.out.println("\n Even Numbers");
		
		for(int i = 0; i < 100; i++) {
			values[i] = i+1;
			if((values[i] % 2) == 0) {
				System.out.println("Values[" + (i+1) + "] = " + values[i]);
			}
		}
		
		/*for(int i = 1; i < 100; i=i+2) {
			System.out.println("Values[" + (i+1) + "] = " + values[i]);
			//i++;
		}*/
	}

}

