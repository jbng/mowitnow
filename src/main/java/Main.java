import java.io.IOException;

import fr.jbng.logic.SceneManager;
import fr.jbng.utils.FileReader;

public class Main {

	public static void main(String... args) throws IOException {
		SceneManager sceneManager = new SceneManager();
		FileReader parser = new FileReader("C:\\temp\\move.txt", sceneManager);
		parser.processLineByLine();
	}

}
