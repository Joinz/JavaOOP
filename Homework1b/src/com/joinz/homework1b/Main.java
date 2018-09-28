package com.joinz.homework1b;

public class Main {

	public static void main(String[] args) {
		
		Triangle triangle1 = new Triangle(2.3, 3, 2);

		System.out.println(triangle1.toString());
		System.out.println(triangle1.getA());
		
		triangle1.setA(5);
		triangle1.setB(5);
		triangle1.setC(5);

		System.out.println(triangle1.toString());
		System.out.println(triangle1.areaOfTriangle());
	}

}
