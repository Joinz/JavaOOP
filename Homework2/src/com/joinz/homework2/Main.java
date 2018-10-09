package com.joinz.homework2;

public class Main {

	public static void main(String[] args) {
		
		Point p1 = new Point(2, 2);
		Point p2 = new Point(4, 5);
		Point p3 = new Point(4, 3);
		Triangle tr = new Triangle(p1, p2, p3);
		Shape sp1 = tr;
		System.out.println(sp1.toString());
		System.out.println("Perimetr of triangle equals " + sp1.getPerimetr());
		System.out.println("Area of triangle equals " + sp1.getArea());
		
		Circle cir =  new Circle(p1, p2);
		Shape sp2 = cir;
		System.out.println(sp2.toString());
		System.out.println("Perimetr of circle equals " + sp2.getPerimetr());
		System.out.println("Area of circle equals " + sp2.getArea());
	}

}
