package fr.jbng.utils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.jbng.logic.SceneManager;
import fr.jbng.utils.FileReader;

public class FileReaderTest {
	private Path filePath;
	private final static Charset ENCODING = StandardCharsets.UTF_8;

	@Before
	public void setUp() throws URISyntaxException {
		assertNotNull("Test file move.txt missing",
				getClass().getResource("/move.txt"));
		URL resourceUrl = getClass().getResource("/move.txt");
		filePath = Paths.get(resourceUrl.toURI());
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testFileLoading() throws IOException {
		assertNotNull("Test file move.txt missing",
				getClass().getResource("/move.txt"));
		SceneManager sceneManager = new SceneManager();
		FileReader reader = new FileReader("/move.txt",sceneManager);
		//reader.processLineByLine();
	}
	
	

}
