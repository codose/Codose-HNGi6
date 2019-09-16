package com.codose.hng_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    public static android.content.SharedPreferences SharedPreferences = null;
    private static final String PREFER_NAME = "SignUp";
    private Button btnSignIn;
    UserSession session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);


        // User Session Manager
        session = new UserSession(getApplicationContext());

        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();
        // User Login button
        btnSignIn = findViewById(R.id.login);

        SharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);

        // Login button click event
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Get username, password from EditText
                String mUsername = username.getText().toString();
                String mPassword = password.getText().toString();

                // Validate if username, password is filled
                if(mUsername.trim().length() > 0 && mPassword.trim().length() > 0){
                    String uName = null;
                    String uPassword =null;

                    if (SharedPreferences.contains("uName"))
                    {
                        uName = SharedPreferences.getString("uName", "");

                    }

                    if (SharedPreferences.contains("Password"))
                    {
                        uPassword = SharedPreferences.getString("Password", "");

                    }

                    // Object uName = null;
                    // Object uEmail = null;
                    if(mUsername.equals(uName) && mPassword.equals(uPassword)){

                        session.createUserLoginSession(uName,
                                uPassword);

                        // Starting MainActivity
                        Intent i = new  Intent(getApplicationContext(),DisplayInfo.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);

                        finish();

                    }else{

                        // username / password doesn't match&
                        Toast.makeText(getApplicationContext(),
                                "Username/Password is incorrect",
                                Toast.LENGTH_LONG).show();

                    }
                }else{

                    // user didn't entered username or password
                    Toast.makeText(getApplicationContext(),
                            "Please enter username and password",
                            Toast.LENGTH_LONG).show();

                }

            }
        });
    }

}
