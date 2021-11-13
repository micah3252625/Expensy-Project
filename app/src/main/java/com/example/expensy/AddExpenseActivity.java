package com.example.expensy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Add Expenses");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, EXPENSES);
        AutoCompleteTextView expense_dropdown = findViewById(R.id.expense_list);
        expense_dropdown.setAdapter(adapter);
    }
    private static final String[] EXPENSES = new String[] {
           "Food", "Clothes", "Netflix", "Entertainment", "Gas"
    };
}