package fr.jbng.constants;

public enum Positioning {
	N("North"), 
	S("South"), 
	E("East"), 
	W("West");

	private final String label;

	Positioning(String label) {
		this.label = label;
	}
}
