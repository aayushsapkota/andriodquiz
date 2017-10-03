package aayush.programmingquiz;

import java.util.ArrayList;


public class selectedAnswer {
    private ArrayList<String> questions = new ArrayList<>();
    String question;
    String answer;

    public selectedAnswer() {
    }

    public void recordEachAnswer(String question, String answer) {
        this.question = question;
        this.answer = answer;
        questions.add(question);
        questions.add(answer);
    }

    public String getQuestion(){
        return this.question;
    }

    public String getAnswer(){
        return this.answer;
    }
}
