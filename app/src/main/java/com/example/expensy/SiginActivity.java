package com.example.expensy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expensy.Data.UserDAO;
import com.example.expensy.Data.UserDatabase;
import com.example.expensy.ViewModel.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

public class SiginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 0;
    private Button signInBtn;
    private TextView toSignUp;
    private GoogleSignInClient mGoogleSignInClient;
    private UserDatabase database;
    private UserDAO db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);

        signInBtn = findViewById(R.id.signInBtn);
        toSignUp = findViewById(R.id.toSignUp);

        database = Room.databaseBuilder(this, UserDatabase.class, "Expensy-Users")
                .allowMainThreadQueries().build();
        db = database.getUserDao();

        signInBtn.setOnClickListener(view -> {
            switch (view.getId()) {
                case R.id.signInBtn:
                    signIn();
                    break;
            }
        });
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // redirect to sign up screen
        toSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(SiginActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }

    /*
    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    } */

    private void updateUI(boolean signedIn) {

        if (signedIn) {
            Intent signInToMain = new Intent(SiginActivity.this, MainActivity.class);
            startActivity(signInToMain);
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, task -> {
                    Toast.makeText(SiginActivity.this, "Not registered. Please sign up first", Toast.LENGTH_SHORT).show();
                });
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            if (account != null) {
                String name = account.getDisplayName();
                String email = account.getEmail();
                User user = db.getUser(name, email);
                if (user != null) {
                    Toast.makeText(SiginActivity.this, "Signed in successfully", Toast.LENGTH_SHORT).show();
                    updateUI(true);
                }
                else {
                    signOut();
                }

            } 
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(false);
        }
    }
}