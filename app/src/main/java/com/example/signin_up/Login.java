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

public class Login extends AppCompatActivity {

    TextInputLayout t1,t2;
    TextView t3;
    ProgressBar bar;
    Button btn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        t1 = findViewById(R.id.email_login);
        t2 = findViewById(R.id.pwd_login);
        t3= findViewById(R.id.textRegister);
        bar = findViewById(R.id.progressBar_1);
        btn = findViewById(R.id.btnLogin);
        mAuth = FirebaseAuth.getInstance();
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Login.this ,MainActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar.setVisibility(View.VISIBLE);

                String email = t1.getEditText().getText().toString().trim();
                String pass = t2.getEditText().getText().toString().trim();

                // Basic validation
                if (email.isEmpty() || pass.isEmpty()) {
                    bar.setVisibility(View.INVISIBLE);
                    t1.setError("Required");
                    t2.setError("Required");
                    return;
                }



                // Firebase Login
                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(task -> {
                            bar.setVisibility(View.INVISIBLE);
                            if (task.isSuccessful()) {
                                // Login successful
                                t1.getEditText().setText("");
                                t2.getEditText().setText("");

                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                // Move to DashboardActivity
                                Intent intent = new Intent(Login.this, Dashboad.class);
                                intent.putExtra("email",mAuth.getCurrentUser().getEmail());
                                intent.putExtra("uid",mAuth.getCurrentUser().getUid());
                                startActivity(intent);
                                finish(); // Optional: Finish login activity
                            } else {
                                // Login failed
                                bar.setVisibility(View.INVISIBLE);
                                t1.getEditText().setText("");
                                t2.getEditText().setText("");
                                Toast.makeText(Login.this, "Login Failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });


    }
}