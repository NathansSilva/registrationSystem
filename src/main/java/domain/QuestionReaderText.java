package domain;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuestionReaderText implements QuestionReader {

    public Question readQuestionsFromFile(String line) {
        String[] columns = line.split("-", 2);
        int number = Integer.parseInt(columns[0].trim());
        String text = columns[1].trim();

        return new Question(number, text);
    }

    public List<Question> readLinesFromQuestion(List<String> lines) {
        List<Question> questions = new ArrayList<>();

        for (String line : lines) {
            questions.add(readQuestionsFromFile(line));
        }

        return questions;
    }
}
