package edu.uwec.cs.hamlingl8131.migration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Migration {
	public static void main(String args[]){
	
	}
	
	public void parseFile(){

	}
	
	public void masterTableInsert(File file){
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/george/Documents/CS260/Assignment2/WY_Features_20111005.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Split the line
	}
}
