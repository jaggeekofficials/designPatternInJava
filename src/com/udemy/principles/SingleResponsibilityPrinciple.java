package com.udemy.principles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SingleResponsibilityPrinciple {
//each class should have only single primary responsibilities 
	// a class should have only one single reason to change.
	// if we will have more than one single responsibilities for class then it is antipattern
	// and will be called as god object.
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
      Journal j = new Journal();
      j.addEntry("I cried today");
      j.addEntry("I ate bug");
      System.out.println(j);
      
      Presistence p = new Presistence();
      String fileName = "C:\\Users\\Jagjeet Sahu\\Documents\\journal.txt";
      p.saveToFile(j, fileName, true);
      
      Runtime.getRuntime().exec("notepad.exe "+fileName);
	}

}

class Journal {
	
	private final  List<String> entries = new ArrayList<>();
	private static int count = 0;
	
	public void addEntry(String text) {
		entries.add(""+(++count) +": "+text);
	}
	
	public void removeEntry(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		//return "Journal [entries=" + entries + "]";
		return String.join(System.lineSeparator(), entries);
	}
	// violation of pattern starts ***
	/*
	 * public void save(String fileName) throws FileNotFoundException { try
	 * (PrintStream out = new PrintStream(fileName)) { out.println(toString()); } }
	 * 
	 * public void load(String fileName) {} public void load(URL url) {}
	 *///*** violation of patterns ends 
	//for different responsibilities we should have different class
	
}

class Presistence{
	
	public void saveToFile(Journal journal, String fileName, boolean overwrite) throws FileNotFoundException {
		
		if(overwrite || new File(fileName).exists()) {
			
			try (PrintStream out = new PrintStream(fileName)) {
				out.println(journal.toString());
			}
			
		}
	}
}