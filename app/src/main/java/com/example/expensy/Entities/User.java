package com.example.expensy.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity// declare class as an Entity
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true) // auto-generated primary key
    @NonNull
    // Column names declaration
    private long id; // user id
    private String name;
    private String email;

    // Constructor contains all elements except id
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    @NonNull
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String username) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
