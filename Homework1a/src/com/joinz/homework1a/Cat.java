package com.joinz.homework1a;

public class Cat {
	private String name;
	private int age;
	private String color;
	private int health;
	private double speed;
	private int punchStrange;
	
	public Cat(String name, int age, String color, int health, double speed, int punchStrange) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		this.health = health;
		this.speed = speed;
		this.punchStrange = punchStrange;
	}

	public Cat() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getPunchStrange() {
		return punchStrange;
	}

	public void setPunchStrange(int punchStrange) {
		this.punchStrange = punchStrange;
	}

	public void meowHappy() {
		System.out.println("I am " + this.name + "!!! Meow =)");
	}
	
	public void meowCrazy() {
		System.out.println("(" + this.name + ")MEEEOOOW!!!");
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", color=" + color + ", health=" + health + ", speed=" + speed
				+ ", punchStrange=" + punchStrange + "]";
	}
	
}
