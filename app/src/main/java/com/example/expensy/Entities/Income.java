package com.example.expensy.Entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "id_fkUser",
        onDelete = CASCADE))

public class Income implements Serializable {
    @PrimaryKey(autoGenerate = true) // auto-generated primary key
    // Column names declaration
    private int income_id; // user id
    private float income_amt;
    private String income_desc;
    private long id_fkUser;


    public Income(float income_amt, String income_desc) {
        this.income_amt = income_amt;
        this.income_desc = income_desc;
    }
    public long getId_fkUser() {
        return id_fkUser;
    }
    public void setId_fkUser(long id) {
        this.id_fkUser = id;
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
