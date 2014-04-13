package fr.jbng.constants;

public enum Direction {
	D("Droite"),
	G("Gauche"),
	A("Avance");
	private final String label;
	Direction(String label){
		this.label = label;
	}
}
