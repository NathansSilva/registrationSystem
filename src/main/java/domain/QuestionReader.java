package domain;

import java.util.List;

public interface QuestionReader {

    Question readQuestionsFromFile(String line);
    List<Question> readLinesFromQuestion(List<String> lines);
    void writingFile(String path, String content);

}