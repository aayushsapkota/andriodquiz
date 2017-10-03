package aayush.programmingquiz;


import java.util.ArrayList;

public class Questions {

    private ArrayList<String> questions;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String answer;

    public Questions() {

    }

    public ArrayList<String> setQuestion(String question, String option1, String option2, String option3, String option4, String answer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;

        questions = new ArrayList<>();
        questions.add(question);
        questions.add(option1);
        questions.add(option2);
        questions.add(option3);
        questions.add(option4);
        questions.add(answer);

        return questions;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getOption1() {
        return this.option1;
    }

    public String getOption2() {
        return this.option2;
    }

    public String getOption3() {
        return this.option3;
    }

    public String getOption4() {
        return this.option4;
    }

    public String getAnswer() {
        return this.answer;
    }

    @Override
    public String toString() {
        return questions.toString();
    }
}
