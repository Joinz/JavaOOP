package com.joinz.homework3;

public class Student extends Human {
	private String surname;

	public Student(String name, int age, Sex sex, String surname) {
		super(name, age, sex);
		this.surname = surname;
	}

	public Student(String name, int age, Sex sex) {
		super();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	@Override
	public String toString() {
		return "Student [name=" + super.getName() + ", age=" + super.getAge() + ", sex=" + super.getSex() + ", surname=" + this.surname + "]";
	}
	
}
