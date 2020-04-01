package com.example.pinsplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        Fragment frag = new SavedFragment();
        trans.replace(R.id.fragment_cont, frag);
        trans.addToBackStack(null);
        trans.commit();
        Button profile = findViewById(R.id.button);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                Fragment frag = new EditProfileFragment();
                trans.replace(R.id.fragment_cont, frag);
                trans.addToBackStack(null);
                trans.commit();
            }
        });

    }

}
