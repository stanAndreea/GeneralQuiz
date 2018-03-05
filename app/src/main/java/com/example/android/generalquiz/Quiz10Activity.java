package com.example.android.generalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Quiz10Activity extends AppCompatActivity {
    private EditText editAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz10);
        Button nextBtn = findViewById(R.id.next10_button);
        editAnswer = findViewById(R.id.edit_answer);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = getIntent().getExtras();
                assert b != null;
                int score = b.getInt("score");
                String name = b.getString("name");
                String answerText = editAnswer.getText().toString();
                System.out.println("/////////" + answerText);
                if (answerText.equalsIgnoreCase("rusia") || answerText.equalsIgnoreCase("russia")) {
                    score++;
                }
                Intent finishIntent = new Intent(Quiz10Activity.this, FinalActivity.class);
                b.putString("name", name);
                b.putInt("score", score);
                finishIntent.putExtras(b);
                startActivity(finishIntent);
            }
        });

    }
}
