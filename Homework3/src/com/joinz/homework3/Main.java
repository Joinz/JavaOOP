package com.joinz.homework3;

import com.joinz.homework3.Group.SortBy;
import com.joinz.homework3.Human.Sex;

public class Main {

	public static void main(String[] args) {
		Student student1 = new Student("Vasya", 18, Sex.Male, "Pupkin");
		Student student2 = new Student("Petya", 21, Sex.Male, "Filimonov");
		Student student3 = new Student("Natasha", 19, Sex.Female, "Popova");
		Student student4 = new Student("Grisha", 17, Sex.Male, "Prohorov");
		Student student5 = new Student("Alena", 21, Sex.Female, "Sobchak");
		Student student6 = new Student("Natasha", 20, Sex.Female, "Volochkova");
		Student student7 = new Student("Mila", 20, Sex.Female, "Yovovich");
		
		Group trolol = new Group("trolol");
		
		try {
			trolol.addStudent(student1);
			trolol.addStudent(student2);
			trolol.addStudent(student3);
			trolol.addStudent(student4);
			trolol.addStudent(student5);
			trolol.addStudent(student6);
			trolol.addStudent(student6);
		} catch (GroupSizeException | AlreadyExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(trolol);
		
		System.out.println(trolol.findStudentBySurname("Filimonov") + " FOUND");
		
		trolol.delStudent("dsada");
		trolol.delStudent("Filimonov");

		System.out.println(trolol.findStudentBySurname("Filimonov") + " FOUND");
		
		System.out.println(trolol.findStudentBySurname("pupkin"));
		System.out.println(trolol.findStudentBySurname("pup"));
		
		try {
			trolol.addStudent(student7);
		} catch (GroupSizeException | AlreadyExistException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(trolol.militaryArray());
		System.out.println();
		
		trolol.sortGroup(SortBy.Name);
		System.out.println(trolol);
		

		trolol.sortGroup(SortBy.Surname, false);
		System.out.println(trolol);
	}
}
