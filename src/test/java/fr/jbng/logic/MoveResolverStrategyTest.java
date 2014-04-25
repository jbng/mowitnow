package fr.jbng.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fr.jbng.actions.api.Step;
import fr.jbng.actions.impl.StepImpl;
import fr.jbng.actors.api.MovesMatrix;
import fr.jbng.actors.api.Mower;
import fr.jbng.actors.impl.MovesMatrixImpl;
import fr.jbng.actors.impl.MowerImpl;
import fr.jbng.constants.Direction;
import fr.jbng.constants.Positioning;
import fr.jbng.logic.api.MoveResolverStrategy;
import fr.jbng.logic.impl.MoveResolverStrategyImpl;
import fr.jbng.utils.Coordinates;

public class MoveResolverStrategyTest {
	

	@Before
	public void setUp(){
		Coordinates coordZero = new Coordinates(0, 0);
		Mower mowerN = new MowerImpl();
		mowerN.setPositioning(Positioning.N);
		mowerN.setCoordinates(coordZero);
		
		Mower mowerS = new MowerImpl();
		mowerS.setPositioning(Positioning.S);
		mowerS.setCoordinates(coordZero);
	}
	@Test
	public void testGetStepResult(){
		Coordinates coordOne = new Coordinates(1, 1);
		Mower mowerN = new MowerImpl();
		mowerN.setPositioning(Positioning.N);
		mowerN.setCoordinates(coordOne);
		assertEquals("1 1 N",mowerN.toString());
		MovesMatrix grassmap = new MovesMatrixImpl(5,5);
		MoveResolverStrategy moveResolve = new MoveResolverStrategyImpl(grassmap);
		
		Step stepA = new StepImpl();
		stepA.setDirection(Direction.A);
		moveResolve.getStepResult(mowerN, stepA);
		assertEquals("1 2 N",mowerN.toString());
		
		Step stepD = new StepImpl();
		stepD.setDirection(Direction.D);
		moveResolve.getStepResult(mowerN, stepD);
		assertEquals("1 2 E",mowerN.toString());
		
	}
	
	@Test
	public void testGetStepsResult() {
		//getStepsResult
	}

}
