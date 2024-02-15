package com.crio.xquiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private String quizName;
    private List<Question> questions;
    private int finalScore;

    // Implement Quiz class constructor : public Quiz(String quizName);
    // Validate:
        // If quizName is null or empty,
            // print "Quiz Name cannot be null or empty!" Note: The statement to be printed should be exactly same.
        // else
            // initialise the quizName with the string taken as input in this constructor
            // initialise the questions to a new and empty arraylist
            // initialise the finalScore to Zero
    public Quiz(String quizName) {
        if (quizName == null || quizName.isEmpty()) {
            System.out.println("Quiz Name cannot be null or empty!");
        } else {
            this.quizName = quizName;
            questions = new ArrayList<>();
            finalScore = 0;
        }
    }

    // Create the getter method : public String getQuizName(), which returns the quizname
    public String getQuizName() {
        return "|----- " + quizName + " -----|";
    }

    // Create the getter method : public List<Question> getQuestions(), which returns the questions list
    public List<Question> getQuestions() {
        return questions;
    }

    // Create the getter method : public int getFinalScore(), which returns the final score
    public int getFinalScore() {
        return finalScore;
    }

    // Create addQuestion() method: public void addQuestion(Question question)
    // Validate:
        // If question is Null,
            // print "Question cannot be null!".
        // If question is not null then,
            // add the question to list of questions.
    public void addQuestion(Question question) {
        if (question == null) {
            System.out.println("Question cannot be null!");
        } else {
            questions.add(question);
        }
    }

    public void attemptQuiz() {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<questions.size(); ++i) { // Iterates over the list of Questions
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.print("Q" + (i+1) + ". ");
            questions.get(i).display(); // Displays the question along with the list of choices
            System.out.print("Choice: ");
            int opt = sc.nextInt(); // Takes in the user input and stores it in integer variable `opt`
            if (opt<1 || opt>questions.get(i).getChoices().size()) {
                // checks if the choice provided by user does not lie in the range of the list of choices
                System.out.println("*Please choose a number between 1 and " + questions.get(i).getChoices().size());
                // asks the user to choose a number between given range
                i--; // the value of i is decremented so that the previous question comes again in the loop and is printed
            } else if (questions.get(i).checkAnswer(questions.get(i).getChoices().get(opt-1))) {
                // else if option lies within the range, then it is checked whether the provided answer is correct
                // if provided answer is correct then the finalScore value is incremented by 1
                finalScore++;
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        sc.close(); // after all the questions are attempted Scanner class instance is closed.
    }

    public void revealAnswerKey() {
        // add loop for printing all the questions along with answers in the questions list.
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Q" + (i+1) + ". " + questions.get(i).getQuestionText() + " (" + questions.get(i).getAnswer() + ")");
        }
        System.out.print("----------------------------------------------------------------------------------------------------");
    }
}
