package com.example.monitorlizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.FileOwnerAttributeView;

public class MealItemList extends AppCompatActivity {

    RecyclerView rvItemList;
    TextView tvMealName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_item_list);

        rvItemList = findViewById(R.id.rvItemList);
        tvMealName = findViewById(R.id.tvMealName);
    }
}