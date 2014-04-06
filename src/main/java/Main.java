import java.io.IOException;

import fr.jbng.logic.MoveReader;

public class Main {

	public static void main(String... args) throws IOException {
		MoveReader parser = new MoveReader("C:\\temp\\move.txt");
		parser.processLineByLine();
	}

}
