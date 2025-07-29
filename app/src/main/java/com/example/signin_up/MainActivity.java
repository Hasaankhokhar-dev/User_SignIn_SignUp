package com.example.signin_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
TextInputLayout t1,t2;
TextView t3;
ProgressBar bar;
Button btn;
private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main);
       t1 = findViewById(R.id.email);
       t2 = findViewById(R.id.pwd);
       t3=  findViewById(R.id.already);

       bar = findViewById(R.id.progressBar);
       btn = findViewById(R.id.btn);

       mAuth = FirebaseAuth.getInstance();
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email = t1.getEditText().getText().toString().trim();
               String password = t2.getEditText().getText().toString().trim();

               if (!email.contains("@") || password.length() < 6) {
                   Toast.makeText(MainActivity.this, "Invalid email or password (min 6 chars)", Toast.LENGTH_SHORT).show();
                   return;
               }
               bar.setVisibility(view.VISIBLE);


               mAuth.createUserWithEmailAndPassword(email, password)
                       .addOnCompleteListener(task -> {
                           if (task.isSuccessful()) {
                               bar.setVisibility(view.INVISIBLE);
                               t1.getEditText().setText("");
                               t2.getEditText().setText("");
                               Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                               // You can redirect user here
                           } else {
                               bar.setVisibility(view.INVISIBLE);
                               Toast.makeText(MainActivity.this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           }
                       });
           }
       });


       t3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, Login.class);
               startActivity(intent);
           }
       });

    }
}