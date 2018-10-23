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
//1. Напишите программу, которая скопирует файлы с заранее
//определенным расширением(например, только doc) из
//каталога источника в каталог приемник.
//2. Напишите программу, которая примет на вход два
//текстовых файла, а вернет один. Содержимым этого файла
//должны быть слова, которые одновременно есть и в первом и
//во втором файле.