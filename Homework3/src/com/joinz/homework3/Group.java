package com.joinz.homework3;

import java.util.Scanner;

public class Group {
	
	private String name;
	private Student[] groupArray = new Student[10];
	public enum SortBy {
		Name, Surname, Age;
	}
	
	public Group(String name) {
		super();
		this.name = name;
	}
	
	public Group() {
		super();
		System.out.println("Input group name:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		this.name = name;
		sc.close();
	}

	public String getName() {
		return name;
	}

	public String addStudent(Student student) throws GroupSizeException {
		String s;
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i] == null) {
				s = student + " successfully added to " + this.getName();
				groupArray[i] = student;
				return s;
			}
		}
		throw new GroupSizeException();
	}
	
	public String delStudent(String surname) {
		String s;
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i] != null && groupArray[i].getSurname().equalsIgnoreCase(surname)) {
				s = groupArray[i] + " successfully deleted";
				groupArray[i] = null;
				return s;
			}
		}
		return "Student is not exist";
	}
	
	public Student findStudentBySurname(String surname) throws HasNotStudentException {
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i] != null && groupArray[i].getSurname().equalsIgnoreCase(surname)) {
				return groupArray[i];
			}
		}
		throw new HasNotStudentException();
	}
	
	public void sortGroup(SortBy param) {
		boolean isSorted = false;
		Student buf;
		while(!isSorted) {
			isSorted = true;
			for (int i = 0; i < groupArray.length-1; i++) {
				if (groupArray[i] == null) {
					continue;
				} else if (groupArray[i+1] == null) {
					isSorted = false;
					buf = groupArray[i];
					groupArray[i] = null;
					groupArray[i+1] = buf;
				} else {
					String s1 = groupArray[i].getSurname();
					String s2 = groupArray[i+1].getSurname();
					if (param == SortBy.Name) {
						s1 = groupArray[i].getName();
						s2 = groupArray[i+1].getName();
					}
					if ((param == SortBy.Name || param == SortBy.Surname) && s1.compareToIgnoreCase(s2) > 0) {
						isSorted = false;
						buf = groupArray[i];
						groupArray[i] = groupArray[i+1];
						groupArray[i+1] = buf;
					}
					if (param == SortBy.Age) {
						int a1 = groupArray[i].getAge();
						int a2 = groupArray[i+1].getAge();
						if (a1 - a2 > 0) {
							isSorted = false;
							buf = groupArray[i];
							groupArray[i] = groupArray[i+1];
							groupArray[i+1] = buf;
						}
					}
				}
			}
		}
		System.out.println("Group " + this.getName() + " has sorted by " + param);
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i] != null) {
				s += System.lineSeparator();
				s += groupArray[i].toString() + ";";
			}
		}
		return "Group " + this.getName() + ":" + s;
	}
}
//1) Создайте класс, описывающий человека (создайте метод,
//выводящий информацию о человеке).
//2) На его основе создайте класс студент (переопределите
//метод вывода информации).
//3) Создайте класс Группа, который содержит массив из 10
//объектов класса Студент. Реализуйте методы добавления,
//удаления студента и метод поиска студента по фамилии. В
//случае попытки добавления 11 студента, создайте
//собственное исключение и обработайте его. Определите
//метод toString() для группы так, что бы он выводил список
//студентов в алфавитном порядке.