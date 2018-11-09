package com.joinz.homework5;

import java.io.File;

public class copySameOfTwoFiles {
	private final static String[] arr = { "txt" };
	public static void copySameOfTwoFiles(File file1, File file2, File fileResult) {
		if (file1 == null || file2 == null || fileResult == null) {
			throw new IllegalArgumentException();
		}
		MyFileFilter mFF = new MyFileFilter(arr);
		
	}
}
