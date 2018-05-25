package com.midasit.challenge.ui.main;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.midasit.challenge.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationview);
        BottomNavigationViewHelper bottomNavigationViewHelper = new BottomNavigationViewHelper();
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment emptyFragment = new Fragment();
        fragmentTransaction.replace(R.id.container, emptyFragment);
        fragmentTransaction.commit();



    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {

            case R.id.search:
                Fragment emptyFragment = new Fragment();
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.container, emptyFragment);
                fragmentTransaction1.commit();
                return true;
        }
        return false;
    };


}


