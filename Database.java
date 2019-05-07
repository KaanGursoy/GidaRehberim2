package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
        private static final String veritabani_adi= "Kullanici_girisi";
        private static final String kullanici_tablosu= "tbl_kullanici";
        private static final int veritabani_versiyon=1;

    public Database(Context context) {
        super (context, veritabani_adi,null,veritabani_versiyon);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tablolar oluşuyor...

        String sql_kullaniciTablosuOlusturma="CREATE TABLE " + kullanici_tablosu + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, KullaniciAd TEXT, KullaniciSoyad TEXT, KullaniciMail TEXT, KullaniciSifre TEXT)";
        db.execSQL(sql_kullaniciTablosuOlusturma);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + kullanici_tablosu);

    }

    public long ekleKullanici(Kullanici kullanici) {
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues cv =new ContentValues ();
        cv.put("KullaniciAdi",kullanici.getAd());
        cv.put ("kullaniciSifresi",kullanici.getSifre());

        long id = db.insert (kullanici_tablosu, null,cv);
        return id;
    }

    public List<Kullanici> getirMusteriListesi() {
        List<Kullanici>kullaniciList= new ArrayList<Kullanici> ();
        SQLiteDatabase db = this.getReadableDatabase ();
        String sqlSorgusu= "Select  *   from " + kullanici_tablosu;

        Cursor c = db.rawQuery (sqlSorgusu,null);

        int siraNoId = c.getColumnIndex ("ID");
        int siraNoAd = c.getColumnIndex ("KullamiciAdi");
        int siraNoSoyad = c.getColumnIndex ("KullaniciSoyad");
        int siraNoMail = c.getColumnIndex ("KullaniciMail");
        int siraNoSifre = c.getColumnIndex ("KullaniciSifre");


        return kullaniciList;
    }
}
