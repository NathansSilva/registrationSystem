package test;

import domain.QuestionAnalyzer;
import domain.QuestionReader;
import domain.QuestionReaderText;
import domain.QuestionService;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String path = "formulario.txt";
        QuestionService questionService = new QuestionService(path);

        while (true) {
            System.out.println("1. List Questions");
            System.out.println("2. Register new user");
            System.out.println("3. List Users");
            System.out.println("4. Add new question");
            System.out.println("5. Remove question");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    questionService.listQuestions();
                    break;
                case 2:
                    questionService.registerUsers(sc);
                    break;
                case 3:
                    questionService.listUsers();
                    break;
                case 4:
                    System.out.print("Type the new question: ");
                    String newQuestion = sc.nextLine();
                    questionService.addQuestions(newQuestion);
                    break;
                case 5:
                    System.out.print("Type the number of the question to be removed: ");
                    int number = Integer.parseInt(sc.nextLine());
                    questionService.removeQuestion(number);
                    break;
                case 6:
                    System.out.println("Closing...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }



    }
}
