package com.joinz.homework3;

public class AlreadyExistException extends Exception{

	@Override
	public String getMessage() {
		return "This student is already in a group!";
	}

}
