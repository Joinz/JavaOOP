package com.joinz.homework1a;

public class Main {

	public static void main(String[] args) {

		Cat cat1 = new Cat("Vasya", 1, "gray", 100, 0, 5);
		Cat cat2 = new Cat("Filya", 5, "red", 70, 10, 50);
		
		System.out.println(cat1);
		System.out.println(cat2); 
		
		if (cat2.getPunchStrange() > cat1.getPunchStrange()) {
			cat1.setSpeed(100);
			cat1.setHealth(cat1.getHealth()/2);
			cat1.meowCrazy();
			cat2.meowHappy();
		} else {
			cat2.setSpeed(100); 
			cat2.setHealth(cat2.getHealth()/2);
			cat2.meowCrazy();
			cat1.meowHappy();
		}
		
		System.out.println(cat1);
		System.out.println(cat2);
	}

}
