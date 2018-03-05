package com.example.android.generalquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.start_button);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = findViewById(R.id.person_name);
                email = findViewById(R.id.emailText);
                final String personalName = name.getText().toString();
                final String hasEmail = email.getText().toString();

                if (isValidName(personalName)) {
                    if (isValidEmail(hasEmail)) {
                        Intent quizIntent = new Intent(MainActivity.this, Quiz2Activity.class);
                        Bundle b = new Bundle();
                        b.putString("name", personalName);
                        quizIntent.putExtras(b);
                        startActivity(quizIntent);
                    } else {
                        displayToast("Invalid email ! ");
                    }

                } else {
                    displayToast("Invalid name ! ");
                }
            }

        });


    }

    public boolean isValidName(String name) {
        String regex = "[a-zA-Z]+";

        return name.matches(regex);

    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }

    public void displayToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
