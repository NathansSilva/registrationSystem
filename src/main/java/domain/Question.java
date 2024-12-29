package domain;

public class Question {

    private int questionNumber;
    private String text;

    public Question(int questionNumber, String text) {
        this.questionNumber = questionNumber;
        this.text = text;
    }

    @Override
    public String toString() {
        return questionNumber + " - " + text;
    }


    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getText() {
        return text;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void setText(String text) {
        this.text = text;
    }
}
