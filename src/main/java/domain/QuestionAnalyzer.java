package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class QuestionAnalyzer {

    private static final String RESOURCES = "src/main/resources";

    public List<Question> analyze(String filename, QuestionReader questionReader) throws IOException {
        Path path = Paths.get(RESOURCES, filename);
        List<String> lines = Files.readAllLines(path);

        return questionReader.readLinesFromQuestion(lines);
    }

    public static void writeFileTxt(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Failed to write file. " + e.getMessage());
        }

    }

}
