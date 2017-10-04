package aayush.programmingquiz;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class quiz extends AppCompatActivity {
    ArrayList<Questions> quizQns = new ArrayList<>();
    static ArrayList<selectedAnswer> savedAnswers = new ArrayList<>();

    private Random randomGenerator;
    private selectedAnswer selectedAns;
    final Handler handler = new Handler();
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String answer;

    private TextView qView;
    private Button bOption1;
    private Button bOption2;
    private Button bOption3;
    private Button bOption4;
    private Button dontKnow;
    private Button Score;
    private Button menu;
    private int times = 0;
    private int score = 0;

    public quiz() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quizQns.clear();
        savedAnswers.clear();

        menu = (Button) findViewById(R.id.mainMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent1 = new Intent(quiz.this, previousResults.class);

        qView = (TextView) findViewById(R.id.question);
        bOption1 = (Button) findViewById(R.id.option1);
        bOption2 = (Button) findViewById(R.id.option2);
        bOption3 = (Button) findViewById(R.id.option3);
        bOption4 = (Button) findViewById(R.id.option4);
        dontKnow = (Button) findViewById(R.id.dontKnow);
        Score = (Button) findViewById(R.id.score);


        displayQuestion();

        bOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String providedAnswer = (String) bOption1.getText();
                recordAnswer(question, providedAnswer);
                checkAnswer(providedAnswer);
            }
        });

        bOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String providedAnswer = (String) bOption2.getText();
                recordAnswer(question, providedAnswer);
                checkAnswer(providedAnswer);
            }
        });

        bOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String providedAnswer = (String) bOption3.getText();
                recordAnswer(question, providedAnswer);
                checkAnswer(providedAnswer);
            }
        });

        bOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String providedAnswer = (String) bOption4.getText();
                recordAnswer(question, providedAnswer);
                checkAnswer(providedAnswer);
            }
        });

        dontKnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordAnswer(question, "user did not answer");
                final AlertDialog.Builder builder = new AlertDialog.Builder(quiz.this);
                builder.setMessage("The right answer is: " + answer).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (times < 4) {
                            displayQuestion();
                        } else {
                            Intent intent = new Intent(quiz.this, endPage.class);
                            intent.putExtra("score", score);
                            startActivity(intent);
                        }
                    }
                }).create().show();
            }
        });


    }

    private void checkAnswer(String selectedAnswer) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(quiz.this);
        if (selectedAnswer == answer) {
            score++;
            Score.setText("SCORE : " + score);

            builder.setMessage("Right Answer").setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (times < 4) {
                        displayQuestion();
                    } else {
                        Intent intent = new Intent(quiz.this, endPage.class);
                        intent.putExtra("score", score);
                        startActivity(intent);
                    }
                }
            }).create().show();

        } else {
            builder.setMessage("Wrong Answer, the right answer is: " + answer).setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (times < 4) {
                        displayQuestion();
                    } else {
                        Intent intent = new Intent(quiz.this, endPage.class);
                        intent.putExtra("score", score);
                        startActivity(intent);
                    }
                }
            }).create().show();
        }
    }

    public ArrayList<selectedAnswer> getSavedAnswers() {
        Log.d("saved answers", savedAnswers.toString());
        return this.savedAnswers;
    }

    private void recordAnswer(String question, String answer) {
        selectedAns = new selectedAnswer();
        selectedAns.recordEachAnswer(question, answer);
        savedAnswers.add(selectedAns);
        Log.d("recordedAnswers", savedAnswers.toString());
    }

    private int getRandomQuestionListIndex() {
        quizQns = getQuestionList();
        randomGenerator = new Random();
        int index = randomGenerator.nextInt(quizQns.size());
        return index;
    }

    private void displayQuestion() {
        int index = getRandomQuestionListIndex();
        Questions retrievedQuestion = quizQns.get(index);

        question = retrievedQuestion.getQuestion();
        option1 = retrievedQuestion.getOption1();
        option2 = retrievedQuestion.getOption2();
        option3 = retrievedQuestion.getOption3();
        option4 = retrievedQuestion.getOption4();
        answer = retrievedQuestion.getAnswer();

        qView.setText(question);
        bOption1.setText(option1);
        bOption2.setText(option2);
        bOption3.setText(option3);
        bOption4.setText(option4);

        times++;
    }

    private ArrayList<Questions> getQuestionList() {
        ArrayList<Questions> questionsList = new ArrayList<>();
        Questions questions = new Questions();
        Questions questions1 = new Questions();
        Questions questions2 = new Questions();
        Questions questions3 = new Questions();
        Questions questions4 = new Questions();
        Questions questions5 = new Questions();
        Questions question6 = new Questions();
        Questions question7 = new Questions();
        Questions question8 = new Questions();

        questions.setQuestion("Name given by a programmer to some data is classified as:", "Identifier",
                "Identification", "exponent", "mantissa", "Identifier");

        questions1.setQuestion("In high level programming language Pascal, each program statement ends with:", "comma",
                "semicolon", "double quotation marks", "single quotation marks", "semicolon");

        questions2.setQuestion("What kind of data structure is LIFO(Last in First Out)", "Array",
                "Queue", "Binary Tree", "Stack", "Stack");

        questions3.setQuestion("How many elements are there in a complete binary tree?", "15",
                "19", "8", "22", "15");

        questions4.setQuestion("The ouput of code below is: \n" +
                        " void main(){ int x = 5; if(x <1 ) printf('hello'); if(x == 5) printf('hi'); else printf('no'); } ",
                "hi", "hello", "no", "none mentioned", "hi");

        questions5.setQuestion("The ouput of code below is: \n" +
                        " int x; void main(){  if(x) printf('hi'); else printf('how are you?'); }",
                "hi", "how are you?", "compile time error", "none mentioned", "how are you?");

        question6.setQuestion("Which is a reserved word in the java programming language?", "method",
                "native", "subclasses", "reference", "native");

        question7.setQuestion("Which is a valid keyword in java?", "interface", "string", "Float",
                "unsigned", "interface");

        question8.setQuestion("Which is the valid declarations within interface defination in java?",
                "public double method();", "public final double method();", "static void method(double d1);",
                "protected void method(double d1);", "public double method()");

        questionsList.add(questions);
        questionsList.add(questions1);
        questionsList.add(questions2);
        questionsList.add(questions3);
        questionsList.add(questions4);
        questionsList.add(questions5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);

        return questionsList;
    }
}
