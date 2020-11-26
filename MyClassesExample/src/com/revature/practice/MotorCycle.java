package com.revature.practice;

public class MotorCycle extends Vehicle {

	@Override
	public void drive() {
		System.out.println("Zooming down the road.");
	}

	public MotorCycle(int wheels, String motor) {
		super(wheels, motor);
		// TODO Auto-generated constructor stub
	}

}
