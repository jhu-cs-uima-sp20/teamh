package com.example.pinsplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.signInToolbar);
        toolbar.setTitle("PinSplorer");
        setContentView(R.layout.activity_sign_in);
    }
}
