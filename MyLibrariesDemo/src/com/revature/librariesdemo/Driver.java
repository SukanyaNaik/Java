package com.revature.librariesdemo;

import java.util.Arrays;
import com.revature.anotherpackage.MyUtils;

public class Driver {

	public static void main(String[] args) {
		int []numbers = {50,20,10,40,30};
		
		System.out.println(numbers);
		System.out.println(Arrays.toString(numbers));
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		int n = 12;
		System.out.println("N = " + n);
		n = MyUtils.addHundred(n);
		System.out.println("N = " + n);
	}

}
