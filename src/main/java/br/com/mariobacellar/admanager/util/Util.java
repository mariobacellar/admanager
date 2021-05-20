package br.com.mariobacellar.admanager.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.ArrayList;

public class Util {

	public static File[] getFiles(String folder) {
		File fileInFolder = new File(folder);
		FileFilter fileFileFilter = new FileFilter() {
			public boolean accept(File file) {
				return !file.isDirectory();
			}
		};
		File[] fileListAsFile = fileInFolder.listFiles(fileFileFilter);
		return fileListAsFile ;	
	}
	
	public static String[] doReadLines(File fileCSV) throws Exception {
		ArrayList<String> lt = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileCSV))) {
			String line = br.readLine();
			while (line != null) {
				lt.add(line);
				line = br.readLine();
			}
		}
		String[] ret = lt.stream().toArray(String[]::new);
		return ret;
	}
	
	public static String convert2String(String[] stringArray) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < stringArray.length; i++) sb.append(stringArray[i]);
		String str = sb.toString();
		return sb.toString();
	}
	
}
