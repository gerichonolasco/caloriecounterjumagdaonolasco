package com.example.caloriecounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstMealWindow extends AppCompatActivity {

    DatabaseReference dbRef;
    EditText editId, textFood, numCalorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_meal_window);
        dbRef = FirebaseDatabase.getInstance("https://caloriecounter-7edb9-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("caloriecounter");
        editId = findViewById(R.id.editID);
        textFood = findViewById(R.id.textFood);
        numCalorie = findViewById(R.id.numCalorie);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width  = dm.widthPixels;
        int height = dm.heightPixels;


        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
    }

    public void insertRecord(View v){
        String id = editId.getText().toString();
        String food = textFood.getText().toString();
        String calories = numCalorie.getText().toString();
        Users users = new Users(food,calories);
        dbRef.child(id).setValue(food).addOnSuccessListener(suc -> {
            Toast.makeText(this,"record inserted...", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(err -> {
            Toast.makeText(this, err.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    public void showData(View v){
        String id = editId.getText().toString();
        DatabaseReference dbDoc = dbRef.child(id);
        ValueEventListener veListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot ds) {
                Users users = ds.getValue(Users.class);
                textFood.setText(users.getFood());
                numCalorie.setText(users.getCalories());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        dbDoc.addValueEventListener(veListener);
    }

    public void updateRecord(View v){
        String id = editId.getText().toString();
        String food = textFood.getText().toString();
        String calories = numCalorie.getText().toString();
        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("food", food);
        userMap.put("calories", calories);
        dbRef.child(id).updateChildren(userMap).addOnSuccessListener(suc -> {
            Toast.makeText(this,"record updated...", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(err -> {
            Toast.makeText(this, err.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    public void deleteRecord(View v){
        String id = editId.getText().toString();
        dbRef.child(id).removeValue().addOnSuccessListener(suc -> {
            Toast.makeText(this,"record deleted...", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(err -> {
            Toast.makeText(this, err.getMessage(), Toast.LENGTH_SHORT).show();
        });

    }

    public void clearEntries(View v){
        editId.setText("");
        textFood.setText("");
        numCalorie.setText("");
    }
}



