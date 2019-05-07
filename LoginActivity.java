package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.login);

        final EditText txtAd = (EditText)findViewById (R.id.txtAd);
        final EditText txtSoyad = (EditText)findViewById (R.id.txtSoyad);
        final EditText txtMail = (EditText)findViewById (R.id.txtMail);
        final EditText txtSifre= (EditText)findViewById (R.id.txtSifre);

        Button buttonKaydet = findViewById (R.id.buttonKaydet);
        Button buttonListele = findViewById (R.id.buttonListele);

        buttonKaydet.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String ad = txtAd.getText ().toString ();
                String soyad = txtSoyad.getText ().toString ();
                String mail = txtMail.getText ().toString ();
                String sifre = txtSifre.getText ().toString ();

                if(ad.isEmpty () || soyad.isEmpty ()) {
                    Toast.makeText (getApplicationContext (), "Alanları boş geçemezsiniz...!", Toast.LENGTH_LONG).show ();
                    return;
                }
            //kaydet butonu

                Kullanici kullanici = new Kullanici (ad,soyad,mail,sifre);
                Database db = new Database (getApplicationContext ());
                long id = db.ekleKullanici(kullanici);

                if (id>0){
                    Toast.makeText (getApplicationContext (),"Kayıt Başarılı...! ID = "+ id,Toast.LENGTH_LONG).show ();
                    txtAd.setText ("");
                    txtSoyad.setText ("");
                    txtMail.setText ("");
                    txtSifre.setText ("");
                }else {
                    Toast.makeText (getApplicationContext (),"Kayıt Başarısız...!",Toast.LENGTH_LONG).show ();
                }

            }
        });

        buttonListele.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (getApplicationContext (),Listele.class);
                startActivity (intent);
            }
        });
    }
    }
