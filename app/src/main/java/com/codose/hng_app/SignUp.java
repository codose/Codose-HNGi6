package com.codose.hng_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Editor editor;
    Button btnSignUp;
    EditText name, username, email, password;
    SharedPreferences sharedPreferences;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.btnSignUp);

        // creating an shared Preference file for the information to be stored
// first argument is the name of file and second is the mode, 0 is private mode

        sharedPreferences = getApplicationContext().getSharedPreferences("SignUp", 0);
// get editor to edit in file
        editor = sharedPreferences.edit();

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v) {

                String mName = name.getText().toString();
                String user = username.getText().toString();
                String mEmail = email.getText().toString();
                String pass = password.getText().toString();

                if(username.getText().length()<=0){
                    Toast.makeText(SignUp.this, "Enter name", Toast.LENGTH_SHORT).show();
                }
                else if( email.getText().length()<=0){
                    Toast.makeText(SignUp.this, "Enter email", Toast.LENGTH_SHORT).show();
                }
                else if( name.getText().length()<=0){
                    Toast.makeText(SignUp.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if( password.getText().length()<=0){
                    Toast.makeText(SignUp.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                else{

                    // as now we have information in string. Lets stored them with the help of editor
                    editor.putString("Name",mName);
                    editor.putString("uName", user);
                    editor.putString("Email",mEmail);
                    editor.putString("Password",pass);
                    editor.apply();}   // commit the values

                // after saving the value open next activity
                openSignIn();

            }
        });


    }

    private void openSignIn() {
        Intent ob = new Intent(this, SignIn.class);
        startActivity(ob);
    }


}
