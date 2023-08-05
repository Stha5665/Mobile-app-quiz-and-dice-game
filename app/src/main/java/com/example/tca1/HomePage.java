package com.example.tca1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends AppCompatActivity {
    // TextView variable
    private TextView elemShowName;
    // TextView variable
    private TextView elemShowPass;
    // TextView variable to show current Date
    private TextView elemShowDate;
    // Button to navigate to play dice
    private Button elemPlayDice;
    // Buttton to play quiz
    private Button elemPlayQuiz;

    // Oncreate  method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        // Linking variables by using id
        elemShowName = findViewById(R.id.elemTvShowName);
        // Linking to show password
        elemShowPass = findViewById(R.id.elemTvShowPass);
        // Linking with textview to show current date
        elemShowDate = findViewById(R.id.elemTvShowDate);
        // linking with play Dice button in layout
        elemPlayDice = findViewById(R.id.homePlayDiceBtn);
        elemPlayQuiz = findViewById(R.id.homePlayQuizBtn); // linking with play quiz button
        // Setting text to show user name
        elemShowName.setText("Welcome " + MainActivity.credentials.getLoggedInUser());
        // LoggedInUser and LoggedInUser are set from main activity which is now getting from this class
        elemShowPass.setText("Your Password: " + MainActivity.credentials.getLoggedInUserPass());
        // getting current date and time of system
        elemShowDate.setText("Current date: " + getDateTime());

        // onClick handler for playDice button
        elemPlayDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if clicked on play Dice than navigate to DiceGameActivity class
                startActivity(new Intent(HomePage.this, DiceGameActiivity.class));
            }
        });// playDice onClickListener ends here

        // setting onClickListener on play quiz button
        elemPlayQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // navigate to QuizGAme class
                startActivity(new Intent(HomePage.this, QuizGame.class));
            }
        });

    }
        // Method to get current system Date and time
        private String getDateTime() {
            // defining format to get Date and time
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();//creating new Date object
            return dateFormat.format(date); // returning Date object on specified format
        }

}// HomePage activity ends here.