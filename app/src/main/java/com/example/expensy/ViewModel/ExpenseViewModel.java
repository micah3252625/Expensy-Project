package com.example.expensy.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.expensy.Entities.Expense;
import com.example.expensy.Repositories.ExpenseRepository;

import java.util.List;

public class ExpenseViewModel extends AndroidViewModel {
    private ExpenseRepository expenseRepository;
    private LiveData<List<Expense>> allExpenses;

    public ExpenseViewModel(@NonNull Application application) {
        super(application);
        expenseRepository = new ExpenseRepository(application);
        allExpenses = expenseRepository.getAllExpense();
    }

    public void insert(Expense expense) {
        expenseRepository.insert(expense);
    }

    public void update(Expense expense) {
        expenseRepository.update(expense);
    }

    public void delete(Expense expense) {
        expenseRepository.delete(expense);
    }

    public void deleteAllExpenses() {
        expenseRepository.deleteAllExpenses();
    }

    public LiveData<List<Expense>> getAllExpenses() {
        return allExpenses;
    }
}
