package com.example.expensy.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.expensy.Entities.Expense;
import java.util.List;

@Dao
public interface ExpenseDAO {
    @Query("SELECT * FROM Expense")
    List<Expense> getAllExpenses();

    @Query("SELECT * FROM Expense WHERE fk_userId=:fk_userId")
    List<Expense> findExpensesForUser(final int fk_userId);

    @Insert
    void insert(Expense user);

    @Update
    void update(Expense user);

    @Delete
    void delete(Expense user);
}
