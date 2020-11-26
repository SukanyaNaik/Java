package com.revature.practice;

public class Tractor extends Vehicle {

	@Override
	public void drive() {
		System.out.println("Getting some dirt.");
	}

	public Tractor(int wheels, String motor) {
		super(wheels, motor);
		// TODO Auto-generated constructor stub
	}

}
