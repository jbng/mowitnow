package fr.jbng.logic.api;

import fr.jbng.actions.api.Step;
import fr.jbng.actors.api.Mower;

public interface MoveResolverStrategy {

	public abstract Mower getStepResult(Mower mower, Step s);

	public abstract Mower getStepsResult(Mower mower);

}