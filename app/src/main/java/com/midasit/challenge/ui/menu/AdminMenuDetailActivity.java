package com.midasit.challenge.ui.menu;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.midasit.challenge.R;

public class AdminMenuDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_detail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("메뉴 상세화면");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }




}
