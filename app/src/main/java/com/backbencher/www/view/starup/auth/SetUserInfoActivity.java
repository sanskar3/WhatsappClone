package com.backbencher.www.view.starup.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.backbencher.www.MainActivity2;
import com.backbencher.www.R;

public class SetUserInfoActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_user_info2);


        button=(Button)findViewById(R.id.btn_next);




    }

    public void btnnext(View view) {
        Intent intent=new Intent(SetUserInfoActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}