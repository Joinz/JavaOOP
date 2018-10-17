package com.joinz.homework3;

import java.util.ArrayList;
import java.util.Arrays;

public class Group {
	private Student[] group = new Student[10];
	
	public String addStudent(Student student, int i) throws GroupSizeException {
		if (i > 0 && i <= 10) {
			if (group[i-1] == null) {
				String s = student + " successfully added to " + i + " place";
				group[i-1] = student;
				return s;
			} else {
				return "This place already taken";
			}
		} else {
			throw new GroupSizeException();
		}
	}
	
	public String delStudent(int i) {
		if (group[i-1] != null) {
			String s = group[i] + " successfully deleted";
			group[i-1] = null;
			return s;
		} else {
			return "Student is not exists";
		}
	}
	
	public Student findStudentBySurname(String surname) throws HasNotStudentException {
		for (int i = 0; i < this.group.length; i++) {
			if (this.group[i] != null && surname == this.group[i].getSurname()) {
				return this.group[i];
			}
		}
		throw new HasNotStudentException();
	}
	
	public ArrayList<String> groupSorted(Group group) {
		String [] surnamesList = new String [10];
		for (int i = 0; i < this.group.length; i++) {
			if (this.group[i] != null) {
				surnamesList[i] = this.group[i].getSurname();
			} else {
				surnamesList[i] = "";
			}
		}
		Arrays.sort(surnamesList);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(surnamesList));
		list.removeAll(Arrays.asList("", null));
		return list;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < group.length; i++) {
			s += System.lineSeparator();
			s+= i+1 + ") ";
			if (group[i] != null) {
				s += group[i].toString() + ";";
			} else {
				s += "Empty place;";
			}
		}
		return "Group [group]:" + s;
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