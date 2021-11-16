package com.example.expensy.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "fk_userId",
        onDelete = CASCADE))
public class Expense implements Serializable {
    @PrimaryKey(autoGenerate = true) // auto-generated primary key
    @NonNull
    // Column names declaration
    private int expense_id; // user id
    private String expense_amount;
    private String expense_category;
    private int fk_userId;

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public String getExpense_amount() {
        return expense_amount;
    }

    public void setExpense_amount(String expense_amount) {
        this.expense_amount = expense_amount;
    }

    public String getExpense_category() {
        return expense_category;
    }

    public void setExpense_category(String expense_category) {
        this.expense_category = expense_category;
    }
    public int getFk_userId() {
        return fk_userId;
    }

    public void setFk_userId(int fk_userId) {
        this.fk_userId = fk_userId;
    }
}
