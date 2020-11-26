package com.sukanya.practice;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("x = " + getRandomNo());
//		System.out.println("y = " + getIntegerRandomNo());
//		System.out.println("z = " + getRangedRandomNo(100,200));
//		System.out.println("a = " + getGeneratedInt(5));
//		System.out.println("b = " + getGeneratedInt1(10,20));
		convertingInttoChar();
	}
	
	public static double getRandomNo() {
		double x = Math.random();
		return x;
	}
	
	public static int getIntegerRandomNo() {
		int x = (int)(Math.random()*10);
		//x = x * 10;
		return x;
	}
	
	public static int getRangedRandomNo(int min, int max) {
		int range = (max - min) + 1;
		int x = (int)(Math.random()*range) + min;
		//x = x * 10;
		return x;
	}
	
	public static int getGeneratedInt(int upperRange) {
		Random random = new Random();
		int x = random.nextInt(upperRange);
		return x;
	}
	
	public static int getGeneratedInt1(int lowerRange, int upperRange) {
		Random random = new Random();
		int x = random.ints(lowerRange, (upperRange+1)).findFirst().getAsInt();
		return x;
	}
	
	public static void convertingInttoChar() {
		char ch;
		for(int i = 65; i <= 90 ; i++) {
			ch = (char)i;
			System.out.println("Value = " + ch);
		}
	}
}
