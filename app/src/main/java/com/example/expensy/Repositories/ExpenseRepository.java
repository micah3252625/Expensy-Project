package com.example.expensy.Repositories;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import com.example.expensy.Data.ExpenseDAO;
import com.example.expensy.Data.ExpensyDatabase;
import com.example.expensy.Entities.Expense;


import java.util.List;

public class ExpenseRepository {
    private ExpenseDAO expenseDAO;
    private LiveData<List<Expense>> allExpense;

    public ExpenseRepository(Application application) {
        ExpensyDatabase database = ExpensyDatabase.getInstance(application);
        expenseDAO = database.getExpenseDao();
        allExpense = expenseDAO.getAllExpenses();
    }

    public void insert(Expense expense) {
        new InsertExpenseAsynchTask(expenseDAO).execute(expense);
    }

    public void update(Expense expense) {
        new UpdateExpenseAsynchTask(expenseDAO).execute(expense);
    }

    public void delete(Expense expense) {
        new DeleteExpenseAsynchTask(expenseDAO).execute(expense);
    }

    public void deleteAllExpenses() {
        new DeleteAllExpenseAsynchTask(expenseDAO).execute();
    }

    public LiveData<List<Expense>> getAllExpense() {
        return allExpense;
    }

    private static class InsertExpenseAsynchTask extends AsyncTask<Expense, Void, Void> {
        private ExpenseDAO expenseDAO;

        private InsertExpenseAsynchTask(ExpenseDAO expenseDAO) {
            this.expenseDAO = expenseDAO;
        }

        @Override
        protected Void doInBackground(Expense... expenses) {
            expenseDAO.insert(expenses[0]);
            return null;
        }
    }

    private static class UpdateExpenseAsynchTask extends AsyncTask<Expense, Void, Void> {
        private ExpenseDAO expenseDAO;

        private UpdateExpenseAsynchTask(ExpenseDAO expenseDAO) {
            this.expenseDAO = expenseDAO;
        }

        @Override
        protected Void doInBackground(Expense... expenses) {
            expenseDAO.update(expenses[0]);
            return null;
        }
    }

    private static class DeleteExpenseAsynchTask extends AsyncTask<Expense, Void, Void> {
        private ExpenseDAO expenseDAO;

        private DeleteExpenseAsynchTask(ExpenseDAO expenseDAO) {
            this.expenseDAO = expenseDAO;
        }

        @Override
        protected Void doInBackground(Expense... expenses) {
            expenseDAO.delete(expenses[0]);
            return null;
        }
    }

    private static class DeleteAllExpenseAsynchTask extends AsyncTask<Void, Void, Void> {
        private ExpenseDAO expenseDAO;

        private DeleteAllExpenseAsynchTask(ExpenseDAO expenseDAO) {
            this.expenseDAO = expenseDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            expenseDAO.deleteAllExpenses();
            return null;
        }
    }


}
