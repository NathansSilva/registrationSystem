package domain;

import java.util.ArrayList;
import java.util.List;

public class QuestionReaderTxt implements QuestionReader {

    @Override
    public Question readQuestionsFromFile(String line) {
        String[] columns = line.split("-", 2);
        int number = Integer.parseInt(columns[0].trim());
        String text = columns[1];

        return new Question(number, text);
    }

    @Override
    public List<Question> readLinesFromQuestion(List<String> lines) {
        List<Question> questions = new ArrayList<>();

        for (String line : lines) {
            questions.add(readQuestionsFromFile(line));
        }

        return questions;
    }
}
