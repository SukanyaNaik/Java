package com.revature.oop;

public class EarthDriver {

	public static void main(String[] args) {
		System.out.println("There is nobody here");
		
		Human person1 = new Human("Bob",34,"Brown","Artist");
		Human person2 = new Human("Eric",38,"Brown","Cool Powers");
		String name1 = person1.getName();
		System.out.println(name1);
		System.out.println("\n");
		System.out.println(person2);
		System.out.println("toString " + person2.toString());
		System.out.println("hashCode " + Integer.toHexString(person2.hashCode()));
		person1.speak();
		person2.speak();
		person1.work();
		
		//Animal animal1 = new Animal(3,"Brown", 52.6);
		Bird pidgeon = new Bird(3,"Gray", 4.4);
		pidgeon.fly();
		pidgeon.sleep();
		
		FlyingMammal bat = new FlyingMammal(10, "Black", 2.2);
		bat.fly();
	}

}
