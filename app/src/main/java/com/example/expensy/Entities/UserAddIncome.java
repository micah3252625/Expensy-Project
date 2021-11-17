package com.example.expensy.Entities;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UserAddIncome {
    @Embedded
    public User user;
    @Relation(
            parentColumn = "user_id",
            entityColumn = "income_id"
    )
    public Income income;

    public UserAddIncome(User user, Income income) {
        this.user = user;
        this.income = income;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }
}
