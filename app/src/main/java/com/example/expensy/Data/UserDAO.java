package com.example.expensy.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.expensy.ViewModel.User;


@Dao
public interface UserDAO {

    @Query("SELECT * FROM User WHERE name = :name and email = :email")
    User getUser(String name, String email);


    @Query("SELECT EXISTS(SELECT * FROM User WHERE name = :name and email = :email)")
    boolean isUserExist(String name, String email);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

}
