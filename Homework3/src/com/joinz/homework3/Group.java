package com.joinz.homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.joinz.homework3.Human.Sex;

public class Group implements MilitaryComissar {
	
	private String groupName;
	private List<Student> groupArray; 
	public enum SortBy {
		Name, Surname, Age;
	}
	
	public Group(String name) {
		super();
		groupArray = new ArrayList<>();
		this.groupName = name;
	}
	
	public Group() {
		super();
		groupArray = new ArrayList<>();
		System.out.println("Input group name:");
		Scanner sc = new Scanner(System.in);
		this.groupName = sc.nextLine();
		sc.close();
	}

	public String getName() {
		return groupName;
	}

	public void setName(String name) {
		this.groupName = name;
	}

	public void addStudent(Student student) throws GroupSizeException, AlreadyExistException {
		if (student == null) {
			throw new IllegalArgumentException("Null student");
		}
		if (groupArray.contains(student)) {
			throw new AlreadyExistException();
		}
		if (groupArray.size() < 10) {
			groupArray.add(student);
			student.setGroup(this.getName());
			return;
		}
		throw new GroupSizeException();
	}
	
	public boolean delStudent(String surname) {
		if (surname == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < groupArray.size(); i++) {
			if (groupArray.get(i) != null && groupArray.get(i).getSurname().equalsIgnoreCase(surname)) {
				groupArray.set(i, null);
				return true;
			}
		}
		return false;
	}
	
	public Student findStudentBySurname(String surname) {
		for (Student student : groupArray) {
			if (student != null && student.getSurname().equalsIgnoreCase(surname)) {
				return student;
			}
		}
		return null;
	}
	
	public void sortGroup(SortBy sortBy) {
		this.groupArray.sort(new StudentComparator(sortBy));
	}
	
	public void sortGroup(SortBy sortBy, boolean sortAsc) {
		this.groupArray.sort(new StudentComparator(sortBy, sortAsc));
	}
	
//	public void sortGroup(SortBy param) {
//		boolean isSorted = false;
//		Student buf;
//		while(!isSorted) {
//			isSorted = true;
//			for (int i = 0; i < groupArray.length-1; i++) {
//				if (groupArray[i] == null) {
//					continue;
//				} else if (groupArray[i+1] == null) {
//					isSorted = false;
//					buf = groupArray[i];
//					groupArray[i] = null;
//					groupArray[i+1] = buf;
//				} else {
//					String s1 = groupArray[i].getSurname();
//					String s2 = groupArray[i+1].getSurname();
//					if (param == SortBy.Name) {
//						s1 = groupArray[i].getName();
//						s2 = groupArray[i+1].getName();
//					}
//					if ((param == SortBy.Name || param == SortBy.Surname) && s1.compareToIgnoreCase(s2) > 0) {
//						isSorted = false;
//						buf = groupArray[i];
//						groupArray[i] = groupArray[i+1];
//						groupArray[i+1] = buf;
//					}
//					if (param == SortBy.Age) {
//						int a1 = groupArray[i].getAge();
//						int a2 = groupArray[i+1].getAge();
//						if (a1 - a2 > 0) {
//							isSorted = false;
//							buf = groupArray[i];
//							groupArray[i] = groupArray[i+1];
//							groupArray[i+1] = buf;
//						}
//					}
//				}
//			}
//		}
//		System.out.println("Group " + this.getName() + " has sorted by " + param);
//	}

	@Override
	public List<Student> militaryArray() {
		List<Student> militaryArray = new ArrayList<>();
		for (Student student : groupArray) {
			if (student != null && student.getSex() == Sex.Male && student.getAge() >= 18) {
				militaryArray.add(student);
			}
		}
		return militaryArray;
	}

	@Override
	public String toString() {
		return "Group name = " + groupName + ", exists = " + groupArray;
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