package com.joinz.homework5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {
	public static void copyFile (File in, File out) throws IOException{
		if (in == null || out == null) {
			throw new IllegalArgumentException();
		}
		
		try (InputStream is = new FileInputStream(in);
				OutputStream os = new FileOutputStream(out)) {
			
			System.out.println("Available bytes = " + is.available());
			byte[] buffer = new byte[1024*1024];
			int n = 0;
			for (; (n = is.read(buffer)) > 0;) {
				os.write(buffer, 0, n);
			}
			
		} catch (IOException e) {
			throw e;
		}
	}
	
	public static void copyFiles(File from, File to, String[] arr) throws IOException {
		if (from == null || to == null) {
			throw new IllegalArgumentException();
		}
		if (!to.exists()) {
			to.mkdir();
		}
		MyFileFilter myFileFilter = new MyFileFilter(arr);
		File[] filteredFileList = from.listFiles(myFileFilter);
		
		for (File file : filteredFileList) {
			String filePath = to + "/" + file.getName();
			System.out.println(filePath);
			File newFile = new File(filePath);
			copyFile(file, newFile);
		}
	}
}
