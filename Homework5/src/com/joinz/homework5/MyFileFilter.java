package com.joinz.homework5;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter{
	private String[] arr;
	
	public MyFileFilter(String[] arr) {
		super();
		this.arr = arr;
	}

	private boolean check(String ext) throws NullPointerException {
		for (String stringExt : arr) {
			if (stringExt == null) {
				throw new NullPointerException();
			}
			if (stringExt.equals(ext)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean accept(File pathname) {
		int pointIndex = pathname.getName().lastIndexOf(".");
		if (pointIndex == -1) {
			return false;
		}
		String ext = pathname.getName().substring(pointIndex + 1);
		boolean check = check(ext);
		return check;
	}
	
}
