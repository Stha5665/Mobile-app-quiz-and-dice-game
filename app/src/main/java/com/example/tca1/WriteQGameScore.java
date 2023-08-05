package com.example.tca1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WriteQGameScore extends AppCompatActivity {

    private TextView tview; // variable of textView
    private EditText quizWriteScore; // variable of EditText
    // Variable of EditText
    private EditText quizWriteName;
    private EditText quizWriteDate;// variable of EditText

    private Button quizEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_qgame_score);

        tview = findViewById(R.id.quizScoreTv); // linking with xml
        quizWriteScore = findViewById(R.id.qEnterScore); // linking with layout by Id
        quizWriteName = findViewById(R.id.qEnterName); // linking
        quizWriteDate = findViewById(R.id.qEnterDate); // linking
        quizEnter = findViewById(R.id.qEnter); // Linking enter button

        quizEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String score = quizWriteScore.getText().toString(); // getting score input
                String name = quizWriteName.getText().toString();// getting name input
                String date = quizWriteDate.getText().toString(); // getting Date input

                //Shared preferences
                SharedPreferences shrd = getSharedPreferences("demo", MODE_PRIVATE);
                // only this application can read this preferences by using MODE_PRIVATE
                SharedPreferences.Editor editor = shrd.edit();

                // save as key value pair like in hashmap
                editor.putString("str", score); // put  input string
                editor.putString("str1", name);// put name string into editor
                editor.putString("str2", date); // put input date into editor
                // adding msg by putString
                editor.apply();
                // apply for input message
                // file is write in disk of android device
                tview.setText("score: " + score); // to show dynamic message
                // if this is not used old message remains there
            }
        });

        // Get the value of shared preference back
        SharedPreferences getShared = getSharedPreferences("demo", MODE_PRIVATE);
        // give file name to access

        String value1 = getShared.getString("str", "Score: "); // give default value also if not found
        String value2 = getShared.getString("str1", "Name: "); // give default value also if not found
        String value3 = getShared.getString("str2", "Date: "); // give default value also if not found
        tview.setText("Last score: "+ value1 +"\nName: " + value2 + "\nDate: "+ value3);// show fetch string
    }

} // End of WriteQGameScore.java