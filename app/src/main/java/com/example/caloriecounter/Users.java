package com.example.caloriecounter;

public class Users {
    String food;
    String calories;

    public Users() {
    }

    public Users(String food, String calories) {
        this.food = food;
        this.calories = calories;
    }

    public String getFood() {
        return food;
    }

    public String getCalories() {
        return calories;
    }
}
