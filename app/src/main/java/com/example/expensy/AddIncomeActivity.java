package com.example.expensy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddIncomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Add Income");

    }

}
