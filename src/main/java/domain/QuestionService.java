package domain;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class QuestionService {

    private List<Question> questions;
    private List<User> users;

    public QuestionService(String filename) {
        QuestionAnalyzer questionAnalyzer = new QuestionAnalyzer();
        QuestionReader questionReader = new QuestionReaderText();

        try {
            this.questions = questionAnalyzer.analyze(filename, questionReader);
        } catch (IOException e) {
            System.out.println("Error loading file. " + e.getMessage());
            this.questions = new ArrayList<>();
        }

        this.users = new ArrayList<>();
    }

    public void listQuestions() {
        System.out.println();
        for (Question question : questions) {
            System.out.println(question);
        }
        System.out.println();
    }

    public void addQuestions(String text) {
        int number = questions.size()+1;
        questions.add(new Question(number, text));
    }

    public void removeQuestion(int number) {
        if(number <= 4) {
            System.out.println("Can't delete questions from 1 - 4.");
        } else {
            questions.removeIf(question -> question.getQuestionNumber() == number);
            System.out.println("Question deleted.");
        }
    }

    public void registerUsers(Scanner sc) {
        try {
            Map<Integer, String> answers = new HashMap<>();

            for (Question question : questions) {
                System.out.print(question.getText() +" ");
                String answer = sc.nextLine();

                if (question.getQuestionNumber() == 2) {
                    int age = Integer.parseInt(answer);
                    if (age < 16) {
                        System.out.println("Age must be greater than 16.");
                        return;
                    }
                } else if(question.getQuestionNumber() == 3) {
                    for (User user : users) {
                        if (user.getEmail().contains(answer)) {
                            System.out.println("E-mail already exists");
                            return;
                        }
                    }

                    if (!emailValidation(answer)) {
                        System.out.println("Invalid e-mail.");
                        return;
                    }
                }else if(question.getQuestionNumber() == 4) {
                    double height = Double.parseDouble(answer);
                    if (height <= 0) {
                        System.out.println("Invalid height.");
                        return;
                    }
                }

                answers.put(question.getQuestionNumber(), answer);
            }

            User user = new User(answers.get(1), Integer.parseInt(answers.get(2)), answers.get(3), Double.parseDouble(answers.get(4)));
            users.add(user);
            System.out.println("User registered.");
            saveUserFile(user);
        } catch (Exception e) {
            System.out.println("Error registering user. " + e.getMessage());
        }
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user);
        }

    }

    private boolean emailValidation(String email) {
        String regex = "([A-Za-z0-9\\d._-])+@([a-zA-Z.])++";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private void saveUserFile(User user) {
        String fileName = "src/main/resources/" + users.size() + "-" + user.getName().toUpperCase() + ".txt";
        String content = user.toString();
        QuestionAnalyzer.writeFileTxt(fileName, content);
    }




}
