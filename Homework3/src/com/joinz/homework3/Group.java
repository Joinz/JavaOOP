package com.joinz.homework3;

import java.util.Scanner;
import com.joinz.homework3.Human.Sex;

public class Group implements MilitaryComissar {
	
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
			if (student == null) {
				throw new IllegalArgumentException("Null student");
			}
			if (groupArray[i] == null) {
				s = student + " successfully added to " + this.getName();
				groupArray[i] = student;
				student.setGroup(this.getName());
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
	public Student[] militaryArray() {
		int n = 0;
		for (Student student : groupArray) {
			if (student != null && student.getSex() == Sex.Male && student.getAge() >= 18) {
				n++;
			}
		}
		Student[] militaryArray = new Student[n];
		int i = 0;
		for (Student student : groupArray) {
			if (student != null && student.getSex() == Sex.Male && student.getAge() >= 18) {
				militaryArray[i++] = student;
			}
		}
		return militaryArray;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Group " + this.getName());
		for (int i = 0; i < groupArray.length; i++) {
			if (groupArray[i] != null) {
				sb.append(System.lineSeparator());
				sb.append(groupArray[i].toString() + ";");
			}
		}
		return sb.toString();
	}
}
//1) �������� �����, ����������� �������� (�������� �����,
//��������� ���������� � ��������).
//2) �� ��� ������ �������� ����� ������� (��������������
//����� ������ ����������).
//3) �������� ����� ������, ������� �������� ������ �� 10
//�������� ������ �������. ���������� ������ ����������,
//�������� �������� � ����� ������ �������� �� �������. �
//������ ������� ���������� 11 ��������, ��������
//����������� ���������� � ����������� ���. ����������
//����� toString() ��� ������ ���, ��� �� �� ������� ������
//��������� � ���������� �������.