package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button rollButton = findViewById(R.id.roll_button);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();
                rollDice();
            }

            private void rollDice() {
                // Find the TextView by its ID
//                TextView resultText = findViewById(R.id.result_text);

                // Create an instance of Random and generate a random number
                Random random = new Random();
                int randomInt = random.nextInt(6) + 1; // Random number between 1 and 6

                int drawableResource;
                switch (randomInt) {
                    case 1:
                        drawableResource = R.drawable.dice_1;
                        break;
                    case 2:
                        drawableResource = R.drawable.dice_2;
                        break;
                    case 3:
                        drawableResource = R.drawable.dice_3;
                        break;
                    case 4:
                        drawableResource = R.drawable.dice_4;
                        break;
                    case 5:
                        drawableResource = R.drawable.dice_5;
                        break;
                    default:
                        drawableResource = R.drawable.dice_6;
                        break;
                }
                ImageView diceImage =  findViewById(R.id.dice_image);
                diceImage.setImageResource(drawableResource);

                // Set the result in the TextView
//                resultText.setText(String.valueOf(randomInt));
            }
        });
    }
}