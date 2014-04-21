package fr.jbng.actors.impl;

import java.util.List;

import fr.jbng.actions.api.Step;
import fr.jbng.actors.api.Mower;
import fr.jbng.constants.Positioning;
import fr.jbng.utils.Coordinates;

public class MowerImpl implements Mower {
	private Coordinates coordinates;
	private Positioning positioning;
	private List<Step> moveSequence;
	
	public MowerImpl(){
		this.coordinates = new Coordinates(0, 0);
		
	}

	@Override
	public void move(Step step) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public void setCoordinates(int x, int y) {
		Coordinates newCoord = new Coordinates(x, y);
		setCoordinates(newCoord);
	}

	@Override
	public Coordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public void setPositioning(Positioning positioning) {
		this.positioning = positioning;
	}

	@Override
	public Positioning getPositioning() {
		return positioning;
	}

	@Override
	public void setMoveSequence(List<Step> stepList) {
		this.moveSequence = stepList;
	}

	@Override
	public List<Step> getMoveSequence() {
		return moveSequence;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append(this.coordinates.getX());
		result.append(' ');
		result.append(this.coordinates.getY());
		result.append(' ');
		result.append(this.positioning);
		return result.toString();
		
	}

}
