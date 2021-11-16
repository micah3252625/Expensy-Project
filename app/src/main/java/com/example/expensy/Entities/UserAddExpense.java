package com.example.expensy.Entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserAddExpense {
    @Embedded
    public User user;
    @Relation(
            parentColumn = "user_id",
            entityColumn  = "expense_id"
    )
    public List<Expense> expenses;

    public UserAddExpense(User user, List<Expense> expenses) {
        this.user = user;
        this.expenses = expenses;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
