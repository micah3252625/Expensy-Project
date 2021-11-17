package com.example.expensy.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.expensy.Entities.Income;
import com.example.expensy.Entities.UserAddIncome;

import java.util.List;

@Dao
public interface IncomeDAO {
    @Transaction
    @Query("SELECT * FROM User")
    List<UserAddIncome> getUserAndIncome();

    @Query("SELECT * FROM Income")
    Income getIncome();

    @Query("SELECT * FROM Income WHERE fk_userId=:fk_userId")
    Income findIncomeForUser(final int fk_userId);
    @Insert
    void insert(Income income);

    @Update
    void update(Income income);

    @Delete
    void delete(Income income);
}
