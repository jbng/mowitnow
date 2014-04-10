package fr.jbng.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.jbng.actions.api.Step;
import fr.jbng.actors.api.Mower;
import fr.jbng.utils.GrassMap;

public class SceneManager {
	private List<Mower> mowerList;
	private List<Step> moveSequence;
	private GrassMap grassMap;

	public SceneManager() {

		this.mowerList = new ArrayList<Mower>();
		this.moveSequence = new ArrayList<Step>();
		this.grassMap = new GrassMap(0, 0);
	}

	public void initGrassMap(String mapsetting) {
		List<String> grassMapSettings = processLine(mapsetting, " ");
		if (!grassMapSettings.isEmpty() && grassMapSettings.size() == 2) {

		}
	}

	public void initMower(String currentLine) {
		// TODO Auto-generated method stub

	}

	public void setMoveSequence(String movesequence) {

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
