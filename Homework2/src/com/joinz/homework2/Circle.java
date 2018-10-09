package com.joinz.homework2;

public class Circle extends Shape {

	private Point p1;
	private Point p2;
	
	public Circle(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	public Circle() {
		super();
	}

	@Override
	public final double getPerimetr() {
		double radius = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
		double perimetr = 2 * Math.PI * radius;
		return perimetr;
	}

	@Override
	public final double getArea() {
		double radius = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
		double area = Math.PI * Math.pow(radius, 2);
		return area;
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	@Override
	public String toString() {
		return "Circle [p1=" + p1 + ", p2=" + p2 + "]";
	}
	
	
}
