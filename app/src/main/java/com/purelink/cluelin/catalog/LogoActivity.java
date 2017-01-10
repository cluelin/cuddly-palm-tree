package com.purelink.cluelin.catalog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LogoActivity extends AppCompatActivity {

    public static CatalogPDF catalogPDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        Thread logoTimer = new Thread() {
            public void run() {
                try {

                    sleep(1000);
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

        catalogPDF = new CatalogPDF(this);


    }

}
