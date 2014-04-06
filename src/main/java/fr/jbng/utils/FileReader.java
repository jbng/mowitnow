package fr.jbng.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import fr.jbng.constants.ParsingRegexp;

public class FileReader {
	private Path filePath = null;

	private final static Charset ENCODING = StandardCharsets.UTF_8;

	public FileReader() {

	}

	public FileReader(String filename) {
		filePath = Paths.get(filename);
	}

	public Path getFilePath() {
		return filePath;
	}

	public void setFilePath(Path filePath) {
		this.filePath = filePath;
	}

	public final void processLineByLine() throws IOException {
		try (Scanner scanner = new Scanner(filePath, ENCODING.name())) {
			while (scanner.hasNextLine()) {
				String currentLine = scanner.nextLine();
				if(currentLine.matches(ParsingRegexp.MAP_SETTING.get())){
					
					log(currentLine);
				}
				 
				if(currentLine.matches(ParsingRegexp.MOW_SETTING.get())){
					log(currentLine);
				}

				if(currentLine.matches(ParsingRegexp.MOVE_SEQUENCE.get())){
					log(currentLine);
				}

			}
		}
	}

	

	private static void log(Object aObject) {
		System.out.println(String.valueOf(aObject));
	}
}
