package com.example.android.generalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Quiz2Activity extends AppCompatActivity {
    private TextView quiz;
    private static int counter = 0;
    private static int counterAnswCorrect = 0;
    private RadioButton answ1, answ2, answ3;
    private QuizAnswer qA = new QuizAnswer();
    private static int score = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quiz = findViewById(R.id.quiz_text_view);
        answ1 = findViewById(R.id.radio_button_1);
        answ2 = findViewById(R.id.radio_button_2);
        answ3 = findViewById(R.id.radio_button_3);
        Button next = findViewById(R.id.next_button);
        setQuestionView();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup rG = findViewById(R.id.radio_group);
                RadioButton clientAnswer = findViewById(rG.getCheckedRadioButtonId());
                correctAnswer();

                if (qA.getCorrectAnswer(counterAnswCorrect) == clientAnswer.getId()) {
                    score++;
                    counterAnswCorrect++;
                }
                if (counter < 8) {
                    setQuestionView();
                } else {
                    counter = 0;
                    Intent quiz9Intent = new Intent(Quiz2Activity.this, QuizActivity.class);
                    Bundle b = getIntent().getExtras();
                    assert b != null;
                    String name = b.getString("name");
                    b.putString("name", name);
                    b.putInt("score", score);
                    quiz9Intent.putExtras(b);
                    score = 1;
                    startActivity(quiz9Intent);
                }

            }
        });


    }

    private void createQuesTionAnswer() {
        qA.setQuiz(R.string.quiz1);
        qA.setQuiz(R.string.quiz2);
        qA.setQuiz(R.string.quiz3);
        qA.setQuiz(R.string.quiz4);
        qA.setQuiz(R.string.quiz5);
        qA.setQuiz(R.string.quiz6);
        qA.setQuiz(R.string.quiz7);
        qA.setQuiz(R.string.quiz8);

        qA.setAnswer1(R.string.answer10);
        qA.setAnswer1(R.string.answer11);
        qA.setAnswer1(R.string.answer12);
        qA.setAnswer1(R.string.answer13);
        qA.setAnswer1(R.string.answer14);
        qA.setAnswer1(R.string.answer15);
        qA.setAnswer1(R.string.answer16);
        qA.setAnswer1(R.string.answer17);

        qA.setAnswer2(R.string.answer20);
        qA.setAnswer2(R.string.answer21);
        qA.setAnswer2(R.string.answer22);
        qA.setAnswer2(R.string.answer23);
        qA.setAnswer2(R.string.answer24);
        qA.setAnswer2(R.string.answer25);
        qA.setAnswer2(R.string.answer26);
        qA.setAnswer2(R.string.answer27);

        qA.setAnswer3(R.string.answer30);
        qA.setAnswer3(R.string.answer31);
        qA.setAnswer3(R.string.answer32);
        qA.setAnswer3(R.string.answer33);
        qA.setAnswer3(R.string.answer34);
        qA.setAnswer3(R.string.answer35);
        qA.setAnswer3(R.string.answer36);
        qA.setAnswer3(R.string.answer37);
    }

    private void correctAnswer() {
        qA.setCorrectAnswer(R.id.radio_button_1);
        qA.setCorrectAnswer(R.id.radio_button_3);
        qA.setCorrectAnswer(R.id.radio_button_2);
        qA.setCorrectAnswer(R.id.radio_button_3);
        qA.setCorrectAnswer(R.id.radio_button_1);
        qA.setCorrectAnswer(R.id.radio_button_2);
        qA.setCorrectAnswer(R.id.radio_button_2);
        qA.setCorrectAnswer(R.id.radio_button_1);
    }

    private void setQuestionView() {
        createQuesTionAnswer();
        quiz.setText(qA.getQuiz(counter));
        answ1.setText(qA.getAnswe1(counter));
        answ2.setText(qA.getAnswe2(counter));
        answ3.setText(qA.getAnswe3(counter));
        counter++;
    }


}
