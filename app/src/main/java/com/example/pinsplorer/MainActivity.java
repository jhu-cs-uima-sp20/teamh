package com.example.pinsplorer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static MainActivity MAINACTIVITY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MAINACTIVITY = this;
        setContentView(R.layout.activity_main);
        switchFragment(new SavedFragment());
        createEditProfileButtonListener();
        createCreatePinSetButtonListener();
        createNavBarListener();
    }
    private void createEditProfileButtonListener() {
        Button profile = findViewById(R.id.button);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new EditProfileFragment());
            }
        });
    }
    private void createCreatePinSetButtonListener() {
        Button addPinSetBtn = findViewById(R.id.button_to_add_pinset);
        addPinSetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new CreatePinSetFragment());
            }
        });
    }
    private void createNavBarListener() {
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        if ((item.getItemId() == R.id.saved_pinsets)) {
                            switchFragment(new SavedFragment());
                            return true;
                        } else {
                            switchFragment(new BrowseFragment());
                            return true;
                        }
                    }
                };
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }
    public void switchFragment(Fragment frag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_cont, frag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
