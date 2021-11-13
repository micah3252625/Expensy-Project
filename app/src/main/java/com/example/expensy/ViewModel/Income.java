package com.example.expensy.ViewModel;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Income implements Serializable {
    @PrimaryKey(autoGenerate = true) // auto-generated primary key
    @NonNull
    // Column names declaration
    private int income_id; // user id
    private float income_amt;
    private String income_desc;

    public Income(float income_amt, String income_desc) {
        this.income_amt = income_amt;
        this.income_desc = income_desc;
    }

    public int getIncome_id() {
        return income_id;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public float getIncome_amt() {
        return income_amt;
    }

    public void setIncome_amt(float income_amt) {
        this.income_amt = income_amt;
    }

    public String getIncome_desc() {
        return income_desc;
    }

    public void setIncome_desc(String income_desc) {
        this.income_desc = income_desc;
    }

    @Override
    public String toString() {
        return "Income{" +
                "income_id=" + income_id +
                ", income_amt=" + income_amt +
                ", income_desc='" + income_desc + '\'' +
                '}';
    }
}
