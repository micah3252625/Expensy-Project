package com.example.expensy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expensy.Data.UserDAO;
import com.example.expensy.Data.ExpensyDatabase;
import com.example.expensy.Entities.User;

public class SignupActivity extends AppCompatActivity {

    private TextView toSignIn;
    private EditText editTextEmail, editTextName;
    private ExpensyDatabase database;
    private UserDAO userDao, db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // redirect to sigin screen
        toSignIn = findViewById(R.id.toSignIn);
        toSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(SignupActivity.this, SiginActivity.class);
            startActivity(intent);
        });

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextName = findViewById(R.id.editTextName);

        database = Room.databaseBuilder(this, ExpensyDatabase.class, "Expensy-Users")
                .allowMainThreadQueries().build();
        db = database.getUserDao();
        userDao = Room.databaseBuilder(this, ExpensyDatabase.class, "Expensy-Users").allowMainThreadQueries()
                .build().getUserDao();


    }



    public void registerUser(View view) {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        boolean userExist = db.isUserExist(name, email);

        if (userExist == true) {
            Toast.makeText(SignupActivity.this, "This account is already registered.", Toast.LENGTH_SHORT).show();
        }
        else {
            User user = new User(name, email);
            db.insert(user);
            Toast.makeText(SignupActivity.this, "Sign up successfully", Toast.LENGTH_SHORT).show();
            // redirect to sign in
            Intent toSigIn = new Intent(SignupActivity.this, SiginActivity.class);
            startActivity(toSigIn);
        }
    }
}