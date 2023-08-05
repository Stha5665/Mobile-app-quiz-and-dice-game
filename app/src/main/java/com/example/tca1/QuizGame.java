package com.example.tca1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizGame extends AppCompatActivity {
    private static TextView qQuestion; // variable of textView
    private static EditText qAnswer; // variable to link with EditText
    private static Button qSubmit; // Button type Variable

    // counter is 4 that declares no of question
    int counter = 4, score = 0;
    int num, result; // num is for to store random numbers
    // result is to store correct answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);
                // linking with xml component
                qQuestion = findViewById(R.id.quizQuestion);
                // linking variable
                qAnswer = findViewById(R.id.quizAnswer);
                // linking with xml component
                qSubmit = findViewById(R.id.quizSubmit);

                // Generating random number
                Random random = new Random();
                num = random.nextInt(11); // random numbers from 0 to 10
                result = num * num*2; // store correct answer
                qQuestion.setText("The " + num + " multiply " + (num*2) + " = "); // set question


                qSubmit.setOnClickListener(new View.OnClickListener() { // onClickListener on submit button
                    @Override
                    public void onClick(View view) {

                        // get user input from EditText
                        String quizAnswer = qAnswer.getText().toString();
                        // check either input is empty or not
                        if (!quizAnswer.isEmpty()) {
                            int myVal = Integer.parseInt(quizAnswer); // parsing string input by user to integer to check whether it matches with result or not

                            checkAnswer(myVal, result); // passing to checkAnswer method
                            counter--; // decreasing counter variable upto 0

                            result = 0; // result = 0 to minimize error

                            if (counter == 3) {
                                Random random1 = new Random();
                                num = random1.nextInt(8); // Random numbers from 0 to 7
                                result = num * num;// settind different question in counter ==3
                                qQuestion.setText("The " + num + " multiply " + (num) + " = ");
                                checkAnswer(myVal, result); // checking answer
                            } else if (counter == 2) { // Generating division question in counter = 2
                                Random random2 = new Random();
                                num = random2.nextInt(6);// random number from 0 to 5
                                result = (num * 2) / num; // getting result
                                qQuestion.setText("The " + (num * 2) + " divide " + (num) + " = ");
                                checkAnswer(myVal, result); // checking answer

                            } else if (counter == 1) { // if counter = 1
                                Random random3 = new Random(); // generate random number
                                num = random3.nextInt(11); // random number from 0 to 10
                                result = num + (num * 2); // storing result
                                qQuestion.setText("The " + num + " add " + (num * 2) + " = "); // set addition question

                                checkAnswer(myVal, result); // check answer
                            } else { // if counter = 0
                                qSubmit.setEnabled(false); //disable submit button
                                qAnswer.setText("Total Score: " + score); // setting question
                                startActivity(new Intent(QuizGame.this, WriteQGameScore.class)); // move to new activity that take input of score, name, current date
                            }

                        }
                    }
                });

            }
            private void checkAnswer(int inputValue, int result){ // method to check answer

                if (inputValue == result){ // if input value is equal to result then increase score
                    score++;
                    Toast.makeText(QuizGame.this, "correct", Toast.LENGTH_SHORT).show();

                }
                else{ // else show incorrect toast message
                    Toast.makeText(this, "incorrect", Toast.LENGTH_SHORT).show();
                }
            }
}
// end of QuizGame.java