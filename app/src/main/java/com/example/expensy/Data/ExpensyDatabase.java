package com.example.expensy.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.expensy.Entities.Expense;
import com.example.expensy.Entities.User;

@Database(entities = {User.class, Expense.class}, version = 1, exportSchema = false)
public abstract class ExpensyDatabase extends RoomDatabase {
    public abstract UserDAO getUserDao();
    public abstract ExpenseDAO getExpenseDao();
}
