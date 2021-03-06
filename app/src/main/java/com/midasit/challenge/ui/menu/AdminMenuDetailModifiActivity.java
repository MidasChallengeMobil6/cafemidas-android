package com.midasit.challenge.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.midasit.challenge.R;


public class AdminMenuDetailModifiActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String RESID = "resId";
    public static final String DESCRIPTION = "description";

    EditText name;
    EditText des;
    ImageView img;
    EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_detail_modifi);

        Toolbar toolbar = (Toolbar)findViewById(R.id.menu_modifi_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("메뉴 수정화면");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        name= (EditText)findViewById(R.id.name_et);
        des= (EditText)findViewById(R.id.detail_cafe_et);
        price= (EditText)findViewById(R.id.price_et);
        img= (ImageView)findViewById(R.id.modifi_img);
        Button modifi =(Button)findViewById(R.id.modification_btn);
        modifi.setOnClickListener(this);

       // Bitmap bitmap = (Bitmap)intent.getExtras().get(RESID);
        name.setText(intent.getStringExtra(NAME));
        price.setText(intent.getStringExtra(PRICE));
      //  if(bitmap !=null){
       //     img.setImageBitmap(bitmap);
       // }
        des.setText(intent.getStringExtra(DESCRIPTION));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.modification_btn:
                Toast.makeText(getApplicationContext(), "수정완료", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
