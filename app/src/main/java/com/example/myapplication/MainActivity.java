package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = findViewById(R.id.button);
        TextView resultText = findViewById(R.id.textView);
        Toast toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT);
        ImageView diceImage = findViewById(R.id.imageView);
        Dice dice = new Dice(diceImage);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast.show();
                resultText.setText(dice.roll());
            }
        });
    }

    class Dice{

        private final Integer numSides = 6;

        private final ImageView diceImage;

        public Dice(ImageView diceImage) {
            this.diceImage = diceImage;
        }

        public String roll(){
            int diceNumber =  (Integer) new Random().nextInt(numSides)+1;
            chooseDiceImg(diceNumber);
            return Integer.toString(diceNumber);
        }

        private void chooseDiceImg(int numSides){
            switch (numSides){
                case 1:
                    diceImage.setImageResource(R.drawable.dice_1);
                    break;
                case 2:
                    diceImage.setImageResource(R.drawable.dice_2);
                    break;
                case 3:
                    diceImage.setImageResource(R.drawable.dice_3);
                    break;
                case 4:
                    diceImage.setImageResource(R.drawable.dice_4);
                    break;
                case 5:
                    diceImage.setImageResource(R.drawable.dice_5);
                    break;
                case 6:
                    diceImage.setImageResource(R.drawable.dice_6);
                    break;

            }
        }

    }
}