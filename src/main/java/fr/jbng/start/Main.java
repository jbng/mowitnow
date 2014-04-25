package fr.jbng.start;

import java.io.InputStream;
import java.io.IOException;

import fr.jbng.actors.api.Mower;
import fr.jbng.utils.FileReader;

public class Main {

	
	public static void main(String... args) throws IOException {
		InputStream contentStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("move.txt");
		SceneManager sceneManager = new SceneManager();
		FileReader parser = new FileReader(contentStream, sceneManager);
		parser.processLineByLine();
		sceneManager.resolveMoves();
		for(Mower mower : sceneManager.getMowerList()){
			System.out.println(mower.toString());
		}
	}

}
