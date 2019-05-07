package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Listele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_listele);

        final EditText txtKullaniciListesi=findViewById (R.id.txtKullaniciListesi);
        Database db = new Database (getApplicationContext ());

        List<Kullanici>kullaniciList= new ArrayList<Kullanici> ();
        kullaniciList=db.getirMusteriListesi();



    }
}
