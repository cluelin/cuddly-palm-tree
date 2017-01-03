package com.purelink.cluelin.catalog;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(500);
                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainIntent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    finish();
                }
            }

        };
        logoTimer.start();

        SharedPreferences appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        Gson gson = new Gson();
        try{
            String json = appSharedPrefs.getString("MyObject", "");
            Type type = new TypeToken<ArrayList<Bitmap>>(){}.getType();
            ArrayList<Bitmap> bitmap= gson.fromJson(json, type);


            Log.d("tag", "비트맵 복원함 ㅎㅎ");
            PdfRenderingPage.FlagForBitmap = false;
            PdfRenderingPage.bitmap = bitmap;

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
