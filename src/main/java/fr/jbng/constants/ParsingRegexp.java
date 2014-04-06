package fr.jbng.constants;

public enum ParsingRegexp {
	MAP_SETTING("(\\d)(\\s)(\\d)"), 
	MOW_SETTING("(\\d)(\\s)(\\d)(\\s)(N|S|E|W)"), 
	MOVE_SEQUENCE("(G|A|D)*");
	private final String regexp;

	ParsingRegexp(String regexp) {
		this.regexp = regexp;
	}
	public String get(){
		return this.regexp;
	}
}
