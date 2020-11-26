package com.revature.oop;

public class Human {
	String name;
	int age;
	String hairColor;
	String superPower;
	
	public Human(String name, int age, String hairColor, String superPower){
		this.name = name;
		this.age = age;
		this.hairColor = hairColor;
		this.superPower = superPower;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	
	public String getHairColor() {
		return this.hairColor;
	}
	
	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}
	
	public String getSuperPower() {
		return this.superPower;
	}
	
	public void speak() {
		System.out.println("Hello there! My Name is " + this.getName() + ".");
	}
	
	public void eat() {
		System.out.println("Eating...");
	}
	
	public void work() {
		System.out.println("Working...");
	}
}
