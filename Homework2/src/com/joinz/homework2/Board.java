package com.joinz.homework2;

import java.util.Arrays;

public class Board {
	private Shape board[] = new Shape[4];

	public Board(Shape[] board) {
		super();
		this.board = board;
	}

	public Board() {
		super();
	}
	
	public void addShape(int i, Shape shape) {
		if (i < 4) {
			board[i] = shape;
		} else {
			System.out.println("Invalid part given");
		}
	}
	
	public void delShape(int i) {
		if (i < 4) {
			board[i] = null;
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
				string += "clear";
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
