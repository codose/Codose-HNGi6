package com.codose.hng_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DisplayInfo extends AppCompatActivity {
    public static android.content.SharedPreferences SharedPreferences = null;
    private static final String PREFER_NAME = "SignUp";
    private String uName;
    private String fullName;
    private String uMail;
    private String dob;
    private String state;
    private String country;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);

        TextView user = findViewById(R.id.userName);
        TextView fName = findViewById(R.id.fullName);
        TextView eMail = findViewById(R.id.mail);
        TextView uDOB = findViewById(R.id.mDOB);
        TextView uState = findViewById(R.id.mState);
        TextView uCountry = findViewById(R.id.mCountry);
        TextView uGender = findViewById(R.id.mGender);
        uName = SharedPreferences.getString("uName", "");
        user.setText(uName);
        fullName = SharedPreferences.getString("Name", "");
        fName.setText(fullName);
        uMail = SharedPreferences.getString("Email", "");
        eMail.setText(uMail);
        dob = SharedPreferences.getString("DOB", "");
        uDOB.setText(dob);
        state = SharedPreferences.getString("State", "");
        uState.setText(state);
        country = SharedPreferences.getString("Country", "");
        uCountry.setText(country);
        gender = SharedPreferences.getString("Gender", "");
        uGender.setText(gender);
    }

}
