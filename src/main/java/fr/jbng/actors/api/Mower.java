package fr.jbng.actors.api;

import java.util.List;

import fr.jbng.actions.api.Step;
import fr.jbng.constants.Positioning;
import fr.jbng.utils.Coordinates;

public interface Mower {
	void move(Step step);

	void setCoordinates(Coordinates coordinates);
	
	void setCoordinates(int x, int y);

	Coordinates getCoordinates();

	void setPositioning(Positioning positioning);

	Positioning getPositioning();
	
	void setMoveSequence(List<Step> stepList);
	
	List<Step> getMoveSequence();
}
