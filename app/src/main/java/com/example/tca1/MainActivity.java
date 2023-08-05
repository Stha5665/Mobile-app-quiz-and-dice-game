package com.example.tca1;
// import are here
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // for userName
    private EditText eUserName;
    //for getting password
    private EditText ePassword;
    private Button eLogin; // Login button
    private TextView eNoOfAtemptsInfo; // No of attempts remaining to login, if you entered wrong username or password

    private TextView eRegister;
    // If new user you can get register by clicking this button
    public static Credentials credentials = new Credentials();
    //Credentials to get or input user login or password

    int counter = 5;
    // counter variable to detect no of attempt remaining
    boolean isValid = false;
    // check validation of user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // linking variable by using id
        eUserName = findViewById(R.id.elemUserName);
        // linking edit text with ePassword
        ePassword = findViewById(R.id.elemPassword);
        // Linking login button
        eLogin = findViewById(R.id.elemLogin);
        // Linking textview
        eNoOfAtemptsInfo = findViewById(R.id.elemtvAtemptsInfo);
        // linking textview that navigates to register activity
        eRegister = findViewById(R.id.elemRegister);

        // if new user and clicked to sign up this Listener is called
        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // then move to new activity named as REgistrationActivity
                startActivity(new Intent(MainActivity.this, REgistrationActivity.class));
                // Move from this class to REgistrationActivity class
            }
        });

        // If login button is clicked following action is proccessed
        eLogin.setOnClickListener(new View.OnClickListener() {
            // getting OnClick method
            @Override
            public void onClick(View view) {
                // Getting userName from EditText
                String logInputUserName = eUserName.getText().toString();
                //Getting password from EditText of main activity
                String logInputPassword = ePassword.getText().toString();

                // check whether user input userName or password is empty or not
                if(logInputUserName.isEmpty() || logInputPassword.isEmpty()){
                    // if it is found empty then text message with "Please enter all details correctly is shown.
                    Toast.makeText(MainActivity.this, "Plese enter all details correctly", Toast.LENGTH_SHORT).show();
                }
                else {
                    // if not empty then check validation
                    isValid = checkValidation(logInputUserName,logInputPassword);
                    // if user is valid user
                    if(isValid){
                        //show Login successfull toast message
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                        /*
                        * Current logged in user details are stored in Credentials class*/

                        credentials.setLoggedInUser(logInputUserName);
                        credentials.setLoggedInUserPass(logInputPassword);
                        //Add the code to go to new Activity
                        Intent intent = new Intent(MainActivity.this, HomePage.class);
                        startActivity(intent);
                        // startActivity means move to new Activity named Homepage
                    }
                    else {
                        // if user input data do not match with registered data then decrease counter variable
                        counter--;
                        // and show Incorrect credentials entered message
                        Toast.makeText(MainActivity.this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();
                        // The text view shows the no of attempts remaining if incorrect details are entered
                        eNoOfAtemptsInfo.setText("No Of attempts remaining: " + counter);
                        // if counter is zero then disable login button
                        if(counter == 0){
                            // Now user cannot get logged in
                            eLogin.setEnabled(false);
                        }
                    }
                }
            }
        });

    }
    // This boolean method/function check for user input
    private boolean checkValidation(String userName, String password){
        // if registered details are not null
        if(REgistrationActivity.credentials != null){
            // if registered details matches with user input data then return
            if (userName.equals(REgistrationActivity.credentials.getUserName()) && password.equals(REgistrationActivity.credentials.getPassword()) || (userName.equals("admin") && password.equals("admin"))) {
                // if user get registered he/she can get logged either with admin username or password
                // or with registered details
                // return true
                return true;
            }
        }
        // admin can also get logged in with fixed user name and password
        else if(userName.equals("admin") && password.equals("admin")){
            return true;
        }
        // if details are incorrect return false
        return false;
    }
}