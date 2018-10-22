package com.joinz.homework3;

import java.util.Scanner;

public class Group {
	
	private String name;
	private Student[] groupArray = new Student[10];
	
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
	
	public void sortGroup() {
		boolean isSorted = false;
		Student buf;
		while(!isSorted) {
			isSorted = true;
			for (int i = 0; i < this.groupArray.length-1; i++) {
				if (this.groupArray[i] == null) {
					continue;
				} else if (this.groupArray[i+1] == null) {
					isSorted = false;
					buf = this.groupArray[i];
					this.groupArray[i] = null;
					this.groupArray[i+1] = buf;
				} else {
					String s1 = this.groupArray[i].getSurname();
					String s2 = this.groupArray[i+1].getSurname();
					if (s1.compareToIgnoreCase(s2) > 0) {
						isSorted = false;
						buf = this.groupArray[i];
						this.groupArray[i] = this.groupArray[i+1];
						this.groupArray[i+1] = buf;
					}
				}
				
			}
		}
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