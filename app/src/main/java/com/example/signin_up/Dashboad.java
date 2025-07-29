package com.example.signin_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboad extends AppCompatActivity {
TextView email,uid;
Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboad);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        email = findViewById(R.id.dummyText1);
        uid = findViewById(R.id.dummyText2);
        logout = findViewById(R.id.btnLogout);

        email.setText("Email: " + getIntent().getStringExtra("email"));
        uid.setText("UID: " + getIntent().getStringExtra("uid"));
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Dashboad.this ,MainActivity.class));
            }
        });
    }
}