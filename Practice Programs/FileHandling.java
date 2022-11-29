package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandling {
	
	File createFile()
	{
		File file = new File("File1.txt");
		
		try {
			if (file.createNewFile()) {
			    System.out.println("File created: " + file.getName());
			  } else {
			    System.out.println("File already exists.");
			  }
		} catch (IOException e) {
			System.out.println("Error occured in creating a File.");
		}
		
		return file;
	}
	
	void read(File file)
	{
		String line =null;
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			line = br.readLine();
			
			while(line!=null)
			{
				System.out.println(line);
				line=br.readLine();
			}
			
			br.close();
		} catch (Exception e) {
			System.out.println("Error occured in reading a File.");
			e.printStackTrace();
		}
		
	}
	File update(File file)
	{
		try {
			FileWriter myWriter = new FileWriter(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the data you want to write: ");
			String line  = br.readLine();
			myWriter.write(line);
		   
			myWriter.close();
		    System.out.println("Successfully wrote to the file.");
			
			
		} catch (IOException e) {
			System.out.println("Error occured in writing a File.");
			e.printStackTrace();
		}
		
		return file;
	}
	void delete(File file)
	{
		if (file.delete()) { 
		      System.out.println("Deleted the file: " + file.getName());
		    } else {
		      System.out.println("Failed to delete the file.");
		    } 
	}

	public static void main(String[] args) {
		FileHandling obj = new FileHandling();
		
		File file = obj.createFile();
		file = obj.update(file);
		obj.read(file);
		//obj.delete(file);
		
		

	}

}
