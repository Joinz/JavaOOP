package com.joinz.homework3;

public class Main {

	public static void main(String[] args) {
		
		Student student1 = new Student("vasya", 20, true, "pupkin");
		System.out.println(student1.toString());
		
		Group group = new Group();
		try {
			System.out.println(group.addStudent(student1, 1));
			System.out.println(group.addStudent(student1, 4));
			System.out.println(group.addStudent(student1, 12));
		} catch (GroupSizeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(group.toString());
		try {
			System.out.println(group.findStudentBySurname(group, "pupkin"));
			System.out.println(group.findStudentBySurname(group, "pup"));
		} catch (HasNotStudentException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
