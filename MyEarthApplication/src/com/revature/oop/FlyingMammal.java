package com.revature.oop;

public class FlyingMammal extends Animal implements Flyable{

	public FlyingMammal(int age, String color, double weight) {
		super(age, color, weight);
	}

	@Override
	public void fly() {
		System.out.println("FlyingMammal is flying");
	}
}
