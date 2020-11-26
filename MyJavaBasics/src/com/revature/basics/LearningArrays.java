package com.revature.basics;

import java.util.Arrays;

public class LearningArrays {

	public static void main(String[] args) {
		int[] values = new int[5];
		
		values[0] = 0;
		values[1] = 1;
		values[2] = 2;
		values[3] = 3;
		
		String[] myString = new String[5];
		String[] anotherString = {"Hello", "World"};
		myString[0] = "First";
		myString[1] = "Second";
		myString[2] = "Third";
		myString[3] = "Fourth";
		 
		System.out.println(Arrays.toString(values));
		System.out.println(Arrays.toString(myString));
		System.out.println(Arrays.toString(anotherString));
	}

}
