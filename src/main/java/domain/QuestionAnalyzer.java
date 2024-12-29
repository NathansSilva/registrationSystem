package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class QuestionAnalyzer {

    private static final String RESOURCES = "src/main/resources";

    public void analyze(String filename, QuestionReader questionReader) throws IOException {
        Path path = Paths.get(RESOURCES, filename);
        List<String> lines = Files.readAllLines(path);

        List<Question> questions = questionReader.readLinesFromQuestion(lines);

        for (Question question : questions) {
            System.out.println(question);
        }
    }
}
