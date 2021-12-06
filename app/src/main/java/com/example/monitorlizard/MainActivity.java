package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnNewMeal, btnViewMeals;

    private ArrayList<Meal> meals = null;
    private ArrayList<MealItem> mealItems = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewMeal = findViewById(R.id.btnNewMeal);
        btnViewMeals = findViewById(R.id.btnViewMeals);

        btnNewMeal.setOnClickListener(v -> {
            if (MealsHolder.meals.size() == 0) {
                MealsHolder.parseJSON(MealsHolder.readFromFile("meals.json", getApplicationContext()));
            }
            startActivity(new Intent(MainActivity.this, NewMeal.class));
        });

        btnViewMeals.setOnClickListener(v -> {
            if (MealsHolder.meals.size() == 0) {
                MealsHolder.parseJSON(MealsHolder.readFromFile("meals.json", getApplicationContext()));
            }
            startActivity(new Intent(MainActivity.this, MealList.class));
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        MealsHolder.writeToFile("meals.json", MealsHolder.toJSON(), getApplicationContext());
    }
}

