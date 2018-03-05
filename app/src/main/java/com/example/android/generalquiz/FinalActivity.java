package com.example.android.generalquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FinalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        final TextView nameTextView = findViewById(R.id.text_name);
        final TextView reviewTextView = findViewById(R.id.text_review);
        Button findScoreBtn = findViewById(R.id.button_find_score);

        Bundle b = getIntent().getExtras();
        assert b != null;
        final int score = b.getInt("score");
        final String name = b.getString("name");

        findScoreBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                nameTextView.setText(name);
                String text = score + " /10 ";
                if (score >= 8) {

                    reviewTextView.setText(R.string.an3);

                } else if (score >= 6) {
                    reviewTextView.setText(R.string.an2);
                } else {
                    reviewTextView.setText(R.string.an1);
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast scoreToast = Toast.makeText(context, text, duration);
                scoreToast.show();
            }
        });

    }

}
