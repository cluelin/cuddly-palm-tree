package com.purelink.cluelin.catalog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LogoActivity extends AppCompatActivity {

    public static CatalogPDF catalogPDF;

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

        catalogPDF = new CatalogPDF(this);

//
//        SharedPreferences appSharedPrefs = PreferenceManager
//                .getDefaultSharedPreferences(this.getApplicationContext());
//        Gson gson = new Gson();
//        try{
//            String json = appSharedPrefs.getString("MyObject", "");
//            Type type = new TypeToken<ArrayList<Bitmap>>(){}.getType();
//            ArrayList<Bitmap> bitmap= gson.fromJson(json, type);
//
//
//            Log.d("tag", "비트맵 복원함 ㅎㅎ");
//            ImageViewPager.FlagForBitmap = false;
//            ImageViewPager.bitmap = bitmap;
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }

    }
}
