package fr.jbng.constants;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParsingRegexpTest {

	@Test
	public void testRegexpMap(){
		String mapRegexp = ParsingRegexp.MAP_SETTING.get();
		System.out.println(mapRegexp);
		String mapSetting = "5 5";
		assertTrue(mapSetting.matches(mapRegexp));
	}
	
	@Test
	public void testRegexpMow(){
		String mowRegexp = ParsingRegexp.MOW_SETTING.get();
		System.out.println(mowRegexp);
		String mowSetting = "1 2 N";
		assertTrue(mowSetting.matches(mowRegexp));
	}
	
	@Test
	public void testRegexpMove(){
		String moveRegexp = ParsingRegexp.MOVE_SEQUENCE.get();
		System.out.println(moveRegexp);
		String moveSequence = "AADAADADDA";
		assertTrue(moveSequence.matches(moveRegexp));
	}

}
