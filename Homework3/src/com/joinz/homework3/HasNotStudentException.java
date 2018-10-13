package com.joinz.homework3;

public class HasNotStudentException extends Exception {

	@Override
	public String getMessage() {
		return "Student is not found";
	}

}
