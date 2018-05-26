package com.midasit.challenge.ui.admin;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.midasit.challenge.R;
import com.midasit.challenge.ui.admin.managemember.ManageMemberFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationview);
        BottomNavigationViewHelper bottomNavigationViewHelper = new BottomNavigationViewHelper();
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment emptyFragment = new ManageMemberFragment();
        fragmentTransaction.replace(R.id.container, emptyFragment);
        fragmentTransaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {


            case R.id.manage:
                Fragment fragment = new ManageMemberFragment();
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.container, fragment);
                fragmentTransaction1.commit();
                return true;
        }

        return false;
    };


}


