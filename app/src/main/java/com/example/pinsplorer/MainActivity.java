package com.example.pinsplorer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

    private void createNavBarListener() {
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.saved_pinsets:
                                switchFragment(new SavedFragment());
                                return true;
                            case R.id.browse_pinsets:
                                switchFragment(new BrowseFragment());
                                return true;
                            case R.id.map_nav:
                                switchFragment(new Map_Fragment());
                                return true;
                            case R.id.follow_pinsets:
                                switchFragment(new FollowFragment());
                                return true;
                            default:
                                return false;
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
