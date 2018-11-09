package com.joinz.homework3;

public class Human {
	private String name;
	private Integer age;
	private Sex sex;
	
	public enum Sex {
		Male, Female;
	}
	
	public Human(String name, Integer age, Sex sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
