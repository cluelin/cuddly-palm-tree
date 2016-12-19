package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LogoActivity extends AppCompatActivity {

    private String mainActivityName = "MainActivity";

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
    }
}
