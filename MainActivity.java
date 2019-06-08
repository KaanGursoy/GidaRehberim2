package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity    {
    private FirebaseAuth auth;
    private FirebaseUser currentUser;

    ImageView kefir;
    ImageView erik;
    ImageView balkabagi;

    public void init (){
        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser ();




        kefir = findViewById (R.id.imageView4);
        kefir.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, kefirNedir.class);
                startActivity (intent);
            }
        });
        erik = findViewById (R.id.imageView8);
        erik.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,erikNedir.class);
                startActivity (intent);
            }
        });
        balkabagi = findViewById (R.id.imageView10);
        balkabagi.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (MainActivity.this,Balkabagi.class);
                startActivity (intent);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
     init ();
    }

    public void LoginButon(View view) {

      Intent intent = new Intent (getApplicationContext (),UserLoginActivity.class);
      startActivity (intent);

    }
    public void kefirNedirClick(View view) {
        Intent intent = new Intent (getApplicationContext (),kefirNedir.class);
        startActivity (intent);

    }
    public void erik(View view) {
        Intent intent = new Intent (getApplicationContext (),erikNedir.class);
        startActivity (intent);

    }

    public void LogoClick(View view) {

        Intent intent = new Intent (MainActivity.this, MainActivity.class);
        startActivity (intent);
    }

    public void balkabagi(View view) {
        Intent intent = new Intent (getApplicationContext (), Balkabagi.class);
        startActivity (intent);
    }



    //Menü kısmının oluşturlması(üç nokta)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu (menu);

         getMenuInflater ().inflate (R.menu.menu_main,menu);

        return true;
    }
        // çıkış işlemi
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected (item);

        if (item.getItemId () == R.id.mainLogout){
            auth.signOut ();
           Intent loginIntent = new Intent (MainActivity.this,UserLoginActivity.class);
           startActivity (loginIntent);
            finish ();
        }

       return true;
   }

    //başlangıçta kullanıcı olup olmadığının kontrolü
    @Override
   protected void onStart() {

       if (currentUser == null){
           Intent userLoginIntent = new Intent (MainActivity.this, UserLoginActivity.class);
           startActivity (userLoginIntent);
           finish ();
        }

        super.onStart ();
   }


 }