package fr.jbng.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.jbng.constants.ParsingRegexp;
import fr.jbng.logic.SceneManager;

public class FileReader {
	private Path filePath = null;

	private SceneManager sceneManager;

	private final static Charset ENCODING = StandardCharsets.UTF_8;
	
	private Logger log = LoggerFactory.getLogger(FileReader.class);

	public FileReader(String filename, SceneManager sceneManager) {
		this.filePath = Paths.get(filename);
		this.sceneManager = sceneManager;
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
				if (currentLine.matches(ParsingRegexp.MAP_SETTING.get())) {
					sceneManager.initGrassMap(currentLine);

				}

				if (currentLine.matches(ParsingRegexp.MOW_SETTING.get())) {
					sceneManager.initMower(currentLine);

				}

				if (currentLine.matches(ParsingRegexp.MOVE_SEQUENCE.get())) {
					sceneManager.setMoveSequence(currentLine);

				}
				log.info(currentLine);
			}
		}
	}

}
