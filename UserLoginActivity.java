package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_user_login);
    }

    //public void clickOnButton(View view) {
    //    Intent intent = new Intent (getApplicationContext (),MainActivity.class);
    //    startActivity (intent);

    //}
}
