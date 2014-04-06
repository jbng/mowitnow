package fr.jbng.actors.api;

import fr.jbng.actions.api.Step;
import fr.jbng.constants.Positioning;
import fr.jbng.logic.Coordinates;

public interface Mower {
	void move(Step step);

	void setCoordinates(int x, int y);

	Coordinates getCoordinates();

	void setPositioning(Positioning positioning);

	Positioning getPositioning();
}
