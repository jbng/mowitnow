package fr.jbng.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.jbng.actions.api.Step;
import fr.jbng.actions.impl.StepImpl;
import fr.jbng.actors.api.Mower;
import fr.jbng.actors.impl.MowerImpl;
import fr.jbng.constants.Direction;
import fr.jbng.constants.Positioning;
import fr.jbng.utils.GrassMap;

public class SceneManager {
	private List<Mower> mowerTempList;
	private List<Mower> mowerList;
	private GrassMap grassMap;
	private Logger log = LoggerFactory.getLogger(SceneManager.class);
	private MoveResolver moveResolver;

	public SceneManager() {

		this.grassMap = new GrassMap(0, 0);
		this.moveResolver = new MoveResolver(grassMap);
		this.mowerTempList = new ArrayList<Mower>();
		this.mowerList = new ArrayList<Mower>();
	}

	public void initGrassMap(String mapsetting) {
		List<String> grassMapSettings = processLine(mapsetting, " ");
		if (!grassMapSettings.isEmpty() && grassMapSettings.size() == 2) {
			try {
				int n = Integer.parseInt(grassMapSettings.get(0));

				int m = Integer.parseInt(grassMapSettings.get(1));

				this.grassMap.setDimension(n, m);
			} catch (NumberFormatException e) {
				log.error("GrassMap setting number format error", e);
			}

		}
	}

	public void initMower(String mowerLine) {
		List<String> mowerSettings = processLine(mowerLine, " ");
		if (!mowerSettings.isEmpty() && mowerSettings.size() == 3) {
			try {
				int x = Integer.parseInt(mowerSettings.get(0));
				int y = Integer.parseInt(mowerSettings.get(1));
				String positioning = mowerSettings.get(2);
				Mower newMower = buildMower(x, y, positioning);
				if (mowerTempList.isEmpty()) {
					mowerTempList.add(newMower);
					log.debug("mowerTempList : mower added");
				} else {
					log.error("Mower Step List setting  order error : "
							+ mowerLine);
				}

			} catch (NumberFormatException e) {
				log.error("Mower setting number format error", e);
			}
		}

	}

	private Mower buildMower(int x, int y, String positioning) {
		Mower resultMower = new MowerImpl();
		if (x != 0 && y != 0 && StringUtils.isNotBlank(positioning)) {
			resultMower.setCoordinates(x, y);
			if (positioning.equalsIgnoreCase("N")) {
				resultMower.setPositioning(Positioning.N);
			}
			if (positioning.equalsIgnoreCase("E")) {
				resultMower.setPositioning(Positioning.E);
			}
			if (positioning.equalsIgnoreCase("S")) {
				resultMower.setPositioning(Positioning.S);
			}
			if (positioning.equalsIgnoreCase("W")) {
				resultMower.setPositioning(Positioning.W);
			}
		}

		return resultMower;
	}

	public void setMoveSequence(String movesequence) {
		log.debug("setMoveSequence : " + movesequence);
		char[] moveChar = movesequence.toCharArray();
		List<Step> tempMoveSequence = new ArrayList<Step>();
		if (moveChar.length != 0) {
			for (char c : moveChar) {
				Step newStep = new StepImpl();
				if (c == 'A') {
					newStep.setDirection(Direction.A);
				}
				if (c == 'D') {
					newStep.setDirection(Direction.D);
				}
				if (c == 'G') {
					newStep.setDirection(Direction.G);
				}
				tempMoveSequence.add(newStep);
			}
			if (!mowerTempList.isEmpty()) {
				Mower mower = mowerTempList.get(0);
				mower.setMoveSequence(tempMoveSequence);
				log.debug("mower : " + mower.toString());
				this.mowerList.add(mower);
				log.debug("mowerList : mower added");
				this.mowerTempList.remove(0);
				log.debug("mowerTempList : mower removed");
			} else {
				log.error("Mower setting order error : " + movesequence);
			}
		} else {
			log.error("Empty or invalid line. Unable to process Move Sequence.");
		}
	}

	protected List<String> processLine(String aLine, String delimiter) {
		log.debug("processLine : " + aLine + " delimiter : " + delimiter);
		List<String> result = new ArrayList<String>();
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter(delimiter);
		while (scanner.hasNext()) {
			// assumes the line has a certain structure
			String value = scanner.next();
			result.add(value);
			log.debug(value + " processed ");
		}
		scanner.close();
		return result;
	}

	public void resolveMoves() {
		if (mowerTempList.size() == 0 && mowerList.size() != 0) {
			for (Mower currentMower : mowerList) {
				Mower mowerMoved = this.moveResolver.getStepsResult(currentMower);
				log.debug(mowerMoved.getCoordinates().toString()+ " " + mowerMoved.getPositioning());
			}
		}
	}

	public List<Mower> getMowerList() {
		return mowerList;
	}

	public void setMowerList(List<Mower> mowerList) {
		this.mowerList = mowerList;
	}

}
