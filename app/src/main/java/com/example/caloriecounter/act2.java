package com.example.caloriecounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class act2 extends AppCompatActivity {
    TextView textFood, numCalorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        textFood = findViewById(R.id.textFood2);
        numCalorie = findViewById(R.id.numCalorie2);
    }

    public void goPrevious(View v){
        Intent intent9 = new Intent(act2.this, FirstMealWindow.class);
        startActivity(intent9);

    }

    public void readIS(View v){
        //1. reference to the TextValues
        //2. read the student.txt file
        try {
            FileInputStream fis = openFileInput("student.txt");
            int readByte = -1;
            StringBuffer readData = new StringBuffer();
            while ((readByte=fis.read()) != -1){
                readData.append((char)readByte);
            }
            String name = readData.substring(0, readData.indexOf(" "));
            String calorie = readData.substring(readData.indexOf(" ") + 1);
            textFood.setText(name);
            numCalorie.setText(calorie);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
