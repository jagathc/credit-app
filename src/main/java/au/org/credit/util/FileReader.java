/**
 * This class reads the input excel file.
 */
package au.org.credit.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jagath
 *
 */
public class FileReader {
	private static final String DATA_FILE_PATH = "src/main/resources/data.csv";

	/**
	 * This method reads a csv file and returns the content as list of lines.
	 * 
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readFile() throws IOException {
		Path path = Paths.get(DATA_FILE_PATH);
		List<String[]> lines = new LinkedList<>();

		if (Files.exists(path)) {
			try (Stream<String> fileLines = Files.lines(path)) {
				lines = fileLines.skip(1).map(line -> line.split(","))
						.collect(Collectors.toList());
			}
		}
		return lines;
	}
}
