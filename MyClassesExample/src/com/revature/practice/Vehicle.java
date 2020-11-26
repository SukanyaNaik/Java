package com.revature.practice;

public abstract class Vehicle {
	int wheels;
	String motor;
	
	public Vehicle(int wheels, String motor) {
		super();
		this.wheels = wheels;
		this.motor = motor;
	}

	public abstract void drive();
}
