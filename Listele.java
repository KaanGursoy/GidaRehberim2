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

        StringBuilder sb = new StringBuilder ();

        for (Kullanici _kullanici : kullaniciList){
            String icerik ="";
            icerik = "ID: " + _kullanici.getId () + "\nAd: " + _kullanici.getAd () + "\nSoyad: " + _kullanici.getSoyad () + "\nMail: " + _kullanici.getMail () + "\nSifre: " + _kullanici.getSifre () + "\n\n\n";
            sb.append (icerik);
        }

        txtKullaniciListesi.setText (sb);


    }
}
