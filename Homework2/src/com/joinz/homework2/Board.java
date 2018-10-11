package com.joinz.homework2;

import java.util.Arrays;

public class Board {
	private Shape board[] = new Shape[4];

	public Board() {
		super();
	}
	
	public void addShape(int i, Shape shape) {
		if (i < board.length && i >= 0) {
			board[i] = shape;
			System.out.println(board[i] + " added");
		} else {
			System.out.println("Invalid part given");
		}
	}
	
	public void delShape(int i) {
		if (i < board.length) {
			board[i] = null;
			System.out.println("Shape deleted");
		} else {
			System.out.println("Invalid part given");
		}
	}
	
	public String allBoard() {
		String string = "";
		double area = 0;
		String info;
		for (int i = 0; i < board.length; i++) {
			string += "part " + (i+1) + ": ";
			if (board[i] != null) {
				string += board[i].toString();
				area += board[i].getArea();
			} else {
				string += "empty";
			}
			string += System.lineSeparator();
		}
		info = "Board has: " + System.lineSeparator() + string + "and summary area " + area;
		return info;
	}

	@Override
	public String toString() {
		return "Board [board=" + Arrays.toString(board) + "]";
	}
	
}
