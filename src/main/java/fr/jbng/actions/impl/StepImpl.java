package fr.jbng.actions.impl;

import fr.jbng.actions.api.Step;
import fr.jbng.constants.Direction;

public class StepImpl implements Step {
	private Direction direction;
	private int unit;

	public Direction getDirection() {

		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;

	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

}
