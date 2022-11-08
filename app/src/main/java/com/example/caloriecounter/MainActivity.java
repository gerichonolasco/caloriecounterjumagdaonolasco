package com.example.caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goalCalories = (Button) findViewById(R.id.goalCalories);
        Button firstMeal = (Button) findViewById(R.id.firstMeal);
        Button secondMeal = (Button) findViewById(R.id.secondMeal);
        Button thirdMeal = (Button) findViewById(R.id.thirdMeal);
        FloatingActionButton addMeal = findViewById(R.id.addMeal);

        goalCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent (MainActivity.this, PopUpWindow.class);
                startActivity(int1);
            }
        });
        firstMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent (MainActivity.this, FirstMealWindow.class);
                startActivity(int2);
            }
        });
        secondMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent (MainActivity.this, SecondMealWindow.class);
                startActivity(int3);
            }
        });
        thirdMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent (MainActivity.this, ThirdMealWindow.class);
                startActivity(int4);
            }
        });
        addMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5 = new Intent (MainActivity.this, AddMealWindow.class);
                startActivity(int5);
            }
        });

        }

    }







