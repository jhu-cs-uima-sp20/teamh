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
    private static final int SAVEDPINSETS = 0;
    private static final int BROWSEPINSETS = 1;
    private static final int EDITPROFILE = 2;
    public static MainActivity MAINACTIVITY;

    private Fragment saved_pinsets, browse_pinsets, edit_profile;
    private SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MAINACTIVITY = this;
        setContentView(R.layout.activity_main);
        switchFragment(new SavedFragment());
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
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_cont, frag);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }

//    public void switchContent(int id, Fragment fragment) {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(id, fragment, fragment.toString());
//        ft.addToBackStack(null);
//        ft.commit();
//    }
    //TODO: not quite working
}
