/**
 * This class reads the input excel file.
 */
package au.org.credit.util;

import au.org.credit.model.Line;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author jagath
 *
 */
public class FileReader {
	private static final String DATA_FILE_PATH = "src/main/resources/data.csv";

	/**
	 * This method reads a csv file and returns the content as stream of lines.
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Stream<Line> readFile() throws IOException {
		Path path = Paths.get(DATA_FILE_PATH);


		if (Files.exists(path)) {
			return Files.lines(path)
					.skip(1)
					.map(line -> line.split(","))
					.map(data -> {
						String name = data[0].trim();
						String parent = data[1].isBlank() ? null : data[1].trim();
						int limit = Integer.parseInt(data[2].trim());
						int directUtilisation = Integer.parseInt(data[3].trim());

						return new Line(name, parent, limit, directUtilisation);
					});
		}

		return Stream.empty();
	}
}
