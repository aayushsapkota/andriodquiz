package aayush.programmingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class endPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);

        final Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        TextView view = (TextView) findViewById(R.id.feedback);
        Button again = (Button) findViewById(R.id.Again);
        Button menu = (Button) findViewById(R.id.Menu);
        String scoreText = String.valueOf(score);
        if (score < 3) {
            view.setText("Your final score is " + scoreText + "\n \n Please! try again for better score");
        } else {
            view.setText("Your final score is " + scoreText + "\n \n Congratulations! You did good");

        }

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(endPage.this, quiz.class);
                startActivity(newIntent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(endPage.this, MainActivity.class);
                startActivity(newIntent);
            }
        });
    }
}

