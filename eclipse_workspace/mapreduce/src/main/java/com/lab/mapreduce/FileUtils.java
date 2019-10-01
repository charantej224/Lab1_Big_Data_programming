package com.lab.mapreduce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtils {

	private static String pathToInputFile = "/home/cloudera/workspaces/Lab_Big_Data_Programming/inputs/Datasets/heroes_information.csv";
	private static String pathToOutputFile = "/home/cloudera/workspaces/Lab_Big_Data_Programming/inputs/Datasets/processed_heroes_information.csv";

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(
				pathToInputFile));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		String stringOutput = "";
		String comma = ",";
		String hash = "#";
		while ((line = reader.readLine()) != null) {
			String lineOutput = "";
			//System.out.println(line);
			int i = 0;
			String[] tokens = line.split(comma);

			for (String token : tokens) {
				if (i < 3) {
					lineOutput = lineOutput + token + comma;
				} else if (i <= tokens.length - 2) {
					lineOutput = lineOutput + token + hash;
				} else {
					lineOutput = lineOutput + token;
				}
				i++;
			}
			//System.out.println(lineOutput);
			stringOutput = stringOutput + lineOutput + ls;
		}
		reader.close();
		//System.out.println(stringOutput);
		FileWriter fw = new FileWriter(new File(pathToOutputFile));
		fw.write(stringOutput);
		fw.close();

	}

}
