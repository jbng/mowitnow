package fr.jbng.logic;

import java.util.List;

import fr.jbng.actions.api.Step;
import fr.jbng.actors.api.Mower;
import fr.jbng.constants.Direction;
import fr.jbng.constants.Positioning;
import fr.jbng.utils.Coordinates;
import fr.jbng.utils.GrassMap;

public class MoveResolver {
	
	private GrassMap grassmap;
	
	public MoveResolver(GrassMap grassmap){
		this.grassmap = grassmap;
	}
	
	public Coordinates getStepResult(Mower mower, Step s) {
		Coordinates mowerStart = mower.getCoordinates();
		Coordinates newCoords = new Coordinates(0,0);
		if((mower.getPositioning() == Positioning.N && s.getDirection()==Direction.G)||
				(mower.getPositioning() == Positioning.S && s.getDirection()==Direction.D)||
				(mower.getPositioning() == Positioning.W && s.getDirection()==Direction.A))	{
			int goBackX = mowerStart.getX() - s.getUnit();
			if(goBackX > 0){
				newCoords.setX(goBackX);
			}else{
				newCoords.setX(mowerStart.getX());
			}
			newCoords.setY(mowerStart.getY());
		}
		if((mower.getPositioning() == Positioning.N && s.getDirection()==Direction.D)||
				(mower.getPositioning() == Positioning.S && s.getDirection()==Direction.G)||
				(mower.getPositioning() == Positioning.E && s.getDirection()==Direction.A)){
			int goForwardX = mowerStart.getX() + s.getUnit();
			if(goForwardX < grassmap.getWidth()){
				newCoords.setX(goForwardX);
			}else{
				newCoords.setX(mowerStart.getX());
			}
			newCoords.setY(mowerStart.getY());
		}
		if((mower.getPositioning() == Positioning.E && s.getDirection()==Direction.G)||
				(mower.getPositioning() == Positioning.W && s.getDirection()==Direction.D)||
				(mower.getPositioning() == Positioning.N && s.getDirection()==Direction.A)){
			int goForwardY = mowerStart.getY() + s.getUnit();
			if(goForwardY < grassmap.getHeight()){
				newCoords.setY(goForwardY);
			}else{
				newCoords.setY(mowerStart.getY());
			}
			newCoords.setX(mowerStart.getX());
		}
		if((mower.getPositioning() == Positioning.E && s.getDirection()==Direction.D)||
				(mower.getPositioning() == Positioning.W && s.getDirection()==Direction.G ||
						(mower.getPositioning() == Positioning.S && s.getDirection()==Direction.A))	){
			int goBackY = mowerStart.getY() - s.getUnit();
			if(goBackY > 0){
				newCoords.setY(goBackY);
			}else{
				newCoords.setY(mowerStart.getY());
			}
			newCoords.setX(mowerStart.getX());
		}
		
		return newCoords;
		
		
	}
	

	
	public Coordinates getStepsResult(Mower mower, List<Step> steps) {
		Coordinates initialCoords = mower.getCoordinates();
		
		Coordinates finalCoords;
		return null;
	}

	public void setGrassMap(GrassMap map) {
		this.grassmap = map;
	}

}
