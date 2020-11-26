package com.revature.practice;

public class Car extends Vehicle {
	boolean sunRoof = false;
	
	
	public Car(int wheels, String motor, boolean sunRoof) {
		super(wheels, motor);
		this.sunRoof = sunRoof;
	}

	@Override
	public void drive() {
		System.out.println("Drives smoothely.");
	}
	//overloading
	public void drive(int miles) {
		System.out.println("Drove " + miles + " miles.");
	}
}
