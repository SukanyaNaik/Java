package com.revature.oop;

public abstract class Animal {
	//String name;
	int age;
	String color;
	double weight;
	
	public Animal() {
		
	}
	//public Animal(String name, int age, String color, double weight) {
	public Animal(int age, String color, double weight) {
		//this.name = name;
		this.age = age;
		this.color = color;
		this.weight = weight;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return this.weight;
	}
	public void eat() {
		System.out.println("Eating...");
	}
	
	public void sleep() {
		System.out.println("Zzzzz...");
	}
	
}
