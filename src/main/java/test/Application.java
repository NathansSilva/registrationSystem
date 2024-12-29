package test;

import domain.QuestionAnalyzer;
import domain.QuestionReader;
import domain.QuestionReaderTxt;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        QuestionReader questionReader = new QuestionReaderTxt();
        QuestionAnalyzer questionAnalyzer = new QuestionAnalyzer();

        try {
            questionAnalyzer.analyze("formulario.txt", questionReader);
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo. " + e.getMessage());
        }


    }
}
