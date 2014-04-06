import java.io.IOException;

import fr.jbng.utils.FileReader;

public class Main {

	public static void main(String... args) throws IOException {
		FileReader parser = new FileReader("C:\\temp\\move.txt");
		parser.processLineByLine();
	}

}
