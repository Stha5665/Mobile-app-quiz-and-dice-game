package com.example.tca1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class REgistrationActivity extends AppCompatActivity {

    private EditText eRegName;// variable for linking with xml component
    private EditText eRegPassword; // variable for linking
    private Button eSubmit; // variable for linking submit button

    public static Credentials credentials; // It ask for input for constructor so create new inside if statement


    @Override
    protected void onCreate(Bundle savedInstanceState) {// onCreate method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


            eRegName = findViewById(R.id.elemRegName); // linking with xml
            eRegPassword = findViewById(R.id.elemRegPassword); // linking Password field with xml
            eSubmit = findViewById(R.id.elemSubmit); // Linking submit button

            // adding onClickListener on eSubmit button
            eSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // getting user input userName
                    String registerUserName = eRegName.getText().toString();
                    String registerPassword = eRegPassword.getText().toString();// getting user input password

                    if(isValid(registerUserName,registerPassword)){  // authorized user' user name and password is set
                        Toast.makeText(REgistrationActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        // Toast message showing Registered successfully message
                        credentials =  new Credentials(registerUserName,registerPassword); // storing valid user input data in credential class
                      }

                }
            });
        }
        // isValid method confirm whether user input is valid or not
        private boolean isValid(String userName, String password)
        {
            // return false for empty username and password length smaller than 8 characters
            if(userName.isEmpty() || password.length() < 8){
                Toast.makeText(this, "Please enter all details, password should be minmum 8 character long", Toast.LENGTH_SHORT).show();
                return false; // returning false
            }
            return true; // if user input field i.e. userName is not empty and password is greater than 8 characters then return true
        }

}
// end of REgistrationActivity