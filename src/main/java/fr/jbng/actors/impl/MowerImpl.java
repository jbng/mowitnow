package fr.jbng.actors.impl;

import fr.jbng.actions.api.Step;
import fr.jbng.actors.api.Mower;
import fr.jbng.constants.Positioning;
import fr.jbng.logic.Coordinates;

public class MowerImpl implements Mower {
	private Coordinates coordinates;
	private Positioning positioning;

	public void move(Step step) {
		// TODO Auto-generated method stub
	}

	public void setCoordinates(int x, int y) {
		coordinates.setX(x);
		coordinates.setY(y);
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setPositioning(Positioning positioning) {
		this.positioning = positioning;
	}

	public Positioning getPositioning() {
		return positioning;
	}

}
