package fr.jbng.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
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

	private Scanner scanner;

	private Logger log = LoggerFactory.getLogger(FileReader.class);

	public FileReader(String filename, SceneManager sceneManager) {
		try {
			this.scanner = new Scanner(Paths.get(filename), ENCODING.name());
		} catch (IOException e) {
			log.error("Can't read file :" + filename, e);
		}
		this.sceneManager = sceneManager;
	}

	public FileReader(InputStream inputStream, SceneManager sceneManager) {
		this.scanner = new Scanner(inputStream, ENCODING.name());
		this.sceneManager = sceneManager;
	}

	public Path getFilePath() {
		return filePath;
	}

	public void setFilePath(Path filePath) {
		this.filePath = filePath;
	}

	public final void processLineByLine() throws IOException {

		while (this.scanner.hasNextLine()) {
			String currentLine = scanner.nextLine();
			if (currentLine.matches(ParsingRegexp.MAP_SETTING.get())) {
				log.debug("Map setting :" + currentLine);
				sceneManager.initGrassMap(currentLine);
			}

			if (currentLine.matches(ParsingRegexp.MOW_SETTING.get())) {
				log.debug("Mower setting :" + currentLine);
				sceneManager.initMower(currentLine);
			}

			if (currentLine.matches(ParsingRegexp.MOVE_SEQUENCE.get())) {
				log.debug("Mower Move Sequence setting :" + currentLine);
				sceneManager.setMoveSequence(currentLine);
			}

		}
	}
}
