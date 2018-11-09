package com.joinz.homework5;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String[] arr = { "pdf" };
		File folder = new File("C://Prog.kiev.ua");
		File to = new File("C://Prog.kiev.ua/Java Start");
		
		try {
			CopyFile.copyFiles(folder, to, arr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
//1. Ќапишите программу, котора€ скопирует файлы с заранее
//определенным расширением(например, только doc) из
//каталога источника в каталог приемник.