import domain.Question;
import domain.QuestionReader;
import domain.QuestionReaderText;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest {

    private QuestionReader statementParser = new QuestionReaderText();

    @Test
    public void shouldReadOneCorrectQuestion(){
        String line = "1 - O que é isso?";
        Question result = statementParser.readQuestionsFromFile(line);

        Question expectedQuestion = new Question(1, "O que é isso?");

        Assert.assertEquals(expectedQuestion.getQuestionNumber(), result.getQuestionNumber());
        Assert.assertEquals(expectedQuestion.getText(), result.getText());
    }

}
