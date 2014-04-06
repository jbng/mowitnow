package fr.jbng.logic;

import java.util.Scanner;

public class SceneManager {
	
	public void setGrassMap(String mapsetting){
		
	}
	
	public void setMow(String mowsetting){
		
	}
	
	public void setMove(String movesequence){
		
	}
	
	protected void processLine(String aLine) {
		// use a second Scanner to parse the content of each line
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter(" ");
		if (scanner.hasNext()) {
			// assumes the line has a certain structure
			String name = scanner.next();
			//log(name);
		} else {
			//log("Empty or invalid line. Unable to process.");
		}
	}
}
