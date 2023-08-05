package com.example.tca1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class DiceGameActiivity extends AppCompatActivity {

    // time is in milli second
    int delayTime = 18; // delay time to roll
    int rollingAnimation = 30; // rolling animation time

    int imagesOfDice[] = new int[]{R.drawable.d1,R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6};
    // creating arrays of dice images


    //defining random object
    Random random = new Random();

    // variable of player1 imageView
   public static ImageView objDie1;
   // variable of player 2 imageView
   public static ImageView objDie2;
   public static LinearLayout diceContainer; // variable of type LinearLayout
    // TextView showing help
   public static TextView textViewHelp;
   // to show result
   public static TextView resultView;

   // onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_game_actiivity);

        // Linking objDie1 with xml component by id
        objDie1 = findViewById(R.id.die1);
        // Linking objDie2
        objDie2 = findViewById(R.id.die2);
        // diceContainer linking
        diceContainer = findViewById(R.id.ContainerOfDice);
        // Help message
        textViewHelp = findViewById(R.id.tvHelp);
        // show result
        resultView = findViewById(R.id.tvResult);

        // onClick on diceContainer so that if we tap on screen, dice get roll
        diceContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {// onClick generate two random number
                Random random = new Random();
                int dice1 = random.nextInt(6);// generate random number from 0-5

                Random random1 = new Random();// creating random object
                int dice2 = random1.nextInt(6); //.. generate random number from 0-5

                if(dice2 > dice1){// If dice 2 is greater than dice 1 then winner is player 2
                    resultView.setText("Winner!!! : Player 2");
                }else if(dice1 > dice2){ // If dice 1 is greater then dice1 is winner
                    resultView.setText("Winner!!! : Player 1");
                }
                else {// If both values are equal then Draw
                    resultView.setText("Result: Draw");
                }
                objDie1.setImageResource(imagesOfDice[dice1]);// setting image according to position generated in random number
                // use random numbers as index of image arrays
                // access images via random number
                objDie2.setImageResource(imagesOfDice[dice2]);


            }
        });

    }

}