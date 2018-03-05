package com.example.android.generalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class QuizActivity extends AppCompatActivity {
    private CheckBox anw0, anw1, anw2, anw3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        anw0 = findViewById(R.id.check_box0);
        anw1 = findViewById(R.id.check_box1);
        anw2 = findViewById(R.id.check_box2);
        anw3 = findViewById(R.id.check_box3);
        Button next = findViewById(R.id.next2_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = getIntent().getExtras();
                assert b != null;
                String name = b.getString("name");
                int score = b.getInt("score");
                score = verific(score);
                b.putString("name", name);
                b.putInt("score", score);

                Intent newQuizIntent = new Intent(QuizActivity.this, Quiz10Activity.class);
                newQuizIntent.putExtras(b);
                startActivity(newQuizIntent);
            }
        });

    }

    private int verific(int score) {
        boolean answ0 = anw0.isChecked();
        boolean answ1 = anw1.isChecked();
        boolean answ2 = anw2.isChecked();
        boolean answ3 = anw3.isChecked();
        if (answ0 && answ1 && !answ2 && answ3) {
            score++;
        }
        return score;
    }

}
