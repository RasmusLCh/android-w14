package com.example.maps.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maps.MapsActivity;
import com.example.maps.R;

public class UserManager extends AppCompatActivity {
    private EditText emailText;
    private EditText passwordText;
    private EditText secretText;
    private Button mapButton;
    private Button logOutbutton;
    private FirebaseManager firebaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        secretText = findViewById(R.id.secretText);
        mapButton = findViewById(R.id.mapbutton);
        logOutbutton = findViewById(R.id.signOutButton);
        firebaseManager = new FirebaseManager(this);

    }
    public void showsecret(){
        secretText.setVisibility(View.VISIBLE);
        mapButton.setVisibility(View.VISIBLE);
        logOutbutton.setVisibility(View.VISIBLE);

    }
    public void hideSecret(){
        secretText.setVisibility(View.INVISIBLE);
        mapButton.setVisibility(View.INVISIBLE);
        logOutbutton.setVisibility(View.INVISIBLE);

    }
    public void signIn(View view){
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if(email.length() > 0 && password.length()>0) {
            firebaseManager.signIn(email, password, this);
        }
    }
    public void signUp(View view){
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if(email.length() > 0 && password.length()>0) {
            firebaseManager.signUp(email, password);
        }
    }
    public void signOut(View view){
        firebaseManager.signOut();
    }
    public void mapButton(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }


}
