package com.example.maps.Authentication;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseManager {
    FirebaseAuth mAuth;
    private UserManager userManager;

    public FirebaseManager(UserManager userManager){
        mAuth = FirebaseAuth.getInstance();
        this.userManager = userManager;
        setupAuthStateListener();
    }
    public void setupAuthStateListener(){
        mAuth.addIdTokenListener(new FirebaseAuth.IdTokenListener() {
            @Override
            public void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth) {
             if (firebaseAuth.getCurrentUser() == null){
                 System.out.println("Signed out");
                 userManager.hideSecret();
             }else{
                 System.out.println("Signed in");
             }
            }
        });
    }
    public void signIn(String email,String pwd,final UserManager userManager){
        mAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(userManager, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    userManager.showsecret();
                } else {
                    System.out.println("Login failed" + task.getException());
                }
            }
        });
        }
        public void signUp(String email,String pwd){
        mAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    System.out.println("Sign up successful" + task.getResult().getUser().getEmail());
                } else {
                    System.out.println("Sign up failed" + task.getException());
                }
            }
        });
    }
    public void signOut(){
        mAuth.signOut();
    }
}
