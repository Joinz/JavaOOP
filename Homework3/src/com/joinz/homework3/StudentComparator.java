package com.joinz.homework3;

import java.util.Comparator;

import com.joinz.homework3.Group.SortBy;

public class StudentComparator implements Comparator<Student>{

	private SortBy sortBy = SortBy.Name;
	private boolean sortAsc = true;
	
	public StudentComparator(SortBy sortBy) {
		super();
		this.sortBy = sortBy;
	}

	

	public StudentComparator(SortBy sortBy, boolean sortAsc) {
		super();
		this.sortBy = sortBy;
		this.sortAsc = sortAsc;
	}


	@Override
	public int compare(Student a, Student b) {

		int sortAsc = (this.sortAsc) ? 1 : -1;
		int notNull = CheckNull.checkNull(a, b);
		if (notNull != CheckNull.NOT_NULL) {
			return notNull;
		}
		
		switch (sortBy) {
		case Name:
			return (a.getName().compareToIgnoreCase(b.getName()) * sortAsc);
		case Surname:
			return (a.getSurname().compareToIgnoreCase(b.getSurname()) * sortAsc);
		case Age:
			return (a.getAge().compareTo(b.getAge()) * sortAsc);
		}
		return 0;
	}
	
}
