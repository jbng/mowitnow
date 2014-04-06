package fr.jbng.actions.api;

import fr.jbng.constants.Direction;

public interface Step {
	Direction getDirection();

	void setDirection(Direction direction);

	int getUnit();

	void setUnit(int unit);
}
