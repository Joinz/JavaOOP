package com.joinz.homework3;

import com.joinz.homework3.Group.SortBy;

public class Main {

	public static void main(String[] args) {
		Student student1 = new Student("Vasya", 20, true, "Pupkin");
		Student student2 = new Student("Petya", 21, true, "Filimonov");
		Student student3 = new Student("Natasha", 19, false, "Popova");
		Student student4 = new Student("Grisha", 19, true, "Prohorov");
		Student student5 = new Student("Alena", 21, false, "Sobchak");
		Student student6 = new Student("Natasha", 20, false, "Volochkova");
		Student student7 = new Student("Mila", 20, false, "Yovovich");
		
		Group trolol = new Group("trolol");
		Group g5kib8 = new Group();
		
		try {
			System.out.println(trolol.addStudent(student1));
			System.out.println(trolol.addStudent(student2));
			System.out.println(trolol.addStudent(student3));
			System.out.println(trolol.addStudent(student4));
			System.out.println(trolol.addStudent(student5));

			System.out.println(g5kib8.addStudent(student1));
			System.out.println(g5kib8.addStudent(student2));
			System.out.println(g5kib8.addStudent(student3));
			System.out.println(g5kib8.addStudent(student4));
			System.out.println(g5kib8.addStudent(student5));
		} catch (GroupSizeException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(g5kib8.findStudentBySurname("Filimonov") + " found");
		} catch (HasNotStudentException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		
		System.out.println(g5kib8.delStudent("dsada"));
		System.out.println(g5kib8.delStudent("Filimonov"));

		try {
			System.out.println(g5kib8.findStudentBySurname("Filimonov") + " found");
		} catch (HasNotStudentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println(g5kib8.findStudentBySurname("pupkin"));
			System.out.println(g5kib8.findStudentBySurname("pup"));
		} catch (HasNotStudentException e) {
			System.out.println(e.getMessage());
		}
		try {
			g5kib8.addStudent(student6);
			g5kib8.addStudent(student7);
		} catch (GroupSizeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		g5kib8.sortGroup(SortBy.Surname);
		System.out.println(g5kib8.toString());
		System.out.println();
		
		trolol.sortGroup(SortBy.Surname);
		System.out.println(trolol.toString());
		System.out.println();
		
		trolol.sortGroup(SortBy.Name);
		System.out.println(trolol.toString());
		System.out.println();
		
		trolol.sortGroup(SortBy.Age);
		System.out.println(trolol.toString());
	}

}
