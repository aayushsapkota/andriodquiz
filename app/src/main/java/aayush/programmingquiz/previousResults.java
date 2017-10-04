package aayush.programmingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class previousResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_results);

        TextView view = (TextView) findViewById(R.id.displayResults);
        Button menu = (Button) findViewById(R.id.toMenu);
        Button playGame = (Button) findViewById(R.id.playGame);


       quiz quiz1 = new quiz();
        ArrayList<selectedAnswer> answers = quiz1.getSavedAnswers();
        Log.d("answersList",answers.toString());
        String answer;
        String question;
        String result ="";
        for(int i =0; i < answers.size(); i++){
            question = answers.get(i).getQuestion();
            try{
            Log.d("question",question);}
            catch (NullPointerException e){
                e.printStackTrace();
            }
            answer = answers.get(i).getAnswer();
            result +=  (i+1)+": " +question + "\n => "+ answer+ "\n\n";
           // Log.d("result",result);
        }

        if(result == null){
            view.setText("Previous Results \n\n No Data present");
        }else{
        view.setText("Previous Results \n\n"+result);
        }

        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(previousResults.this, quiz.class);
                startActivity(newIntent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(previousResults.this, MainActivity.class);
                startActivity(newIntent);
            }
        });
    }
}
