package com.joinz.homework3;


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
	
	public Student findStudentBySurname(Group group, String surname) throws HasNotStudentException {
		for (int i = 0; i < this.group.length; i++) {
			if (this.group[i] != null && surname == this.group[i].getSurname()) {
				return this.group[i];
			} 
		}
		throw new HasNotStudentException();
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