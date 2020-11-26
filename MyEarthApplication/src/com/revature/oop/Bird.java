package com.revature.oop;

public class Bird extends Animal implements Flyable{

	public Bird(int age, String color, double weight) {
		super(age,color,weight);
	}
	
	@Override
	public void fly() {
		System.out.println("Bird is Flying...");
	}
}
