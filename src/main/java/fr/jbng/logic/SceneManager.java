package fr.jbng.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.jbng.actors.api.Mower;
import fr.jbng.utils.GrassMap;

public class SceneManager {
	private List<Mower> mowerList;
	private List<String> moveSequence;
	private GrassMap grassMap;

	public void setGrassMap(String mapsetting) {
		List<String> grassMapSettings = processLine(mapsetting, " ");
		if (!grassMapSettings.isEmpty()){
			for(String setting: grassMapSettings){
				
			}
		}
	}

	public void setMower(String mowsetting) {

	}

	public void setMove(String movesequence) {

	}

	protected List<String> processLine(String aLine, String delimiter) {
		List<String> result = new ArrayList<String>();
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter(delimiter);
		if (scanner.hasNext()) {
			// assumes the line has a certain structure
			String name = scanner.next();
			result.add(name);
			// log(name);
		} else {
			// log("Empty or invalid line. Unable to process.");
		}
		return result;
	}
}
