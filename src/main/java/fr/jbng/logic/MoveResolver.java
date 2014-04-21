package fr.jbng.logic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.jbng.actions.api.Step;
import fr.jbng.actors.api.Mower;
import fr.jbng.constants.Direction;
import fr.jbng.constants.Positioning;
import fr.jbng.utils.Coordinates;
import fr.jbng.utils.GrassMap;

public class MoveResolver {
	private Logger log = LoggerFactory.getLogger(MoveResolver.class);

	private GrassMap grassmap;

	public MoveResolver(GrassMap grassmap) {
		this.grassmap = grassmap;
	}

	public Mower getStepResult(Mower mower, Step s) {
		Coordinates mowerCoords = mower.getCoordinates();
		if ((mower.getPositioning() == Positioning.W && s.getDirection() == Direction.A)) {
			int goBackX = mowerCoords.getX() - s.getUnit();
			if (goBackX >= 0) {
				mowerCoords.setX(goBackX);
			}
		}else if ((mower.getPositioning() == Positioning.E && s.getDirection() == Direction.A)) {
			int goForwardX = mowerCoords.getX() + s.getUnit();
			if (goForwardX <= grassmap.getWidth()) {
				mowerCoords.setX(goForwardX);
			}
		}else if ((mower.getPositioning() == Positioning.N && s.getDirection() == Direction.A)) {
			int goForwardY = mowerCoords.getY() + s.getUnit();
			if (goForwardY <= grassmap.getHeight()) {
				mowerCoords.setY(goForwardY);
			}
		}else if ((mower.getPositioning() == Positioning.S && s.getDirection() == Direction.A)) {
			int goBackY = mowerCoords.getY() - s.getUnit();
			if (goBackY >= 0) {
				mowerCoords.setY(goBackY);
			}
		}
		if ((mower.getPositioning() == Positioning.E && s.getDirection() == Direction.D)
				|| (mower.getPositioning() == Positioning.W && s.getDirection() == Direction.G)) {
			mower.setPositioning(Positioning.S);
		}else if ((mower.getPositioning() == Positioning.E && s.getDirection() == Direction.G)
				|| (mower.getPositioning() == Positioning.W && s.getDirection() == Direction.D)) {
			mower.setPositioning(Positioning.N);
		}else if ((mower.getPositioning() == Positioning.N && s.getDirection() == Direction.D)
				|| (mower.getPositioning() == Positioning.S && s.getDirection() == Direction.G)) {
			mower.setPositioning(Positioning.E);
		}else if ((mower.getPositioning() == Positioning.N && s.getDirection() == Direction.G)
				|| (mower.getPositioning() == Positioning.S && s.getDirection() == Direction.D)) {
			mower.setPositioning(Positioning.W);
		}
		return mower;

	}

	public Mower getStepsResult(Mower mower) {
		List<Step> stepList = mower.getMoveSequence();
		Mower tempMower = mower;
		for (Step unitStep : stepList) {
			log.debug("getStepsResult, tempMower :" + tempMower.toString() + " Step :" +unitStep.toString());
			tempMower = getStepResult(tempMower, unitStep);
			
		}
		return tempMower;
	}

	public void setGrassMap(GrassMap map) {
		this.grassmap = map;
	}

}
