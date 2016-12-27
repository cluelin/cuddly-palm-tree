package com.purelink.cluelin.catalog;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class LogoActivity extends AppCompatActivity {

    private android.graphics.pdf.PdfRenderer mPdfRenderer;
    private android.graphics.pdf.PdfRenderer.Page mCurrentPage;
    public static ArrayList<Bitmap> bitmap = null;

    private String mainActivityName = "MainActivity";
    private static String PDF_NAME_IN_DEVICE = "purelink2016.pdf";
    private static String PDF_NAME_IN_ASSET = "purelink2016.pdf";

    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        //show logo
        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    //logo appear time
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


        //디렉토리에 있는 PDF_NAME_IN_DEVICE 파일을 찾아서
        file = new File(getFilesDir(), PDF_NAME_IN_DEVICE);

        //if file exist, don't copy file
        if (file.exists()){
            Log.d("파일", "PDF 파일 존재함!");
            return;
        }else{
            CopyAssetToSDcard();
        }

        if (bitmap == null){
            bitmap = new ArrayList<>();
            Log.d("bitmap", "bitmap 이 null 상태임 ");
            try {
                openRenderer();
                convertImageToBitmap();
                closeRenderer();

            } catch (IOException e) {
                e.printStackTrace();

            }

        }




    }

    private void CopyAssetToSDcard() {

        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;

        try {

            in = assetManager.open(PDF_NAME_IN_ASSET);

            Log.d("timeStamp", "에셋 파일 읽기 성공");
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    private void openRenderer() throws IOException {

        Log.d("timeStamp", "파일 패스 : " + getCacheDir().getPath() + "/" + PDF_NAME_IN_DEVICE);
        mPdfRenderer = new android.graphics.pdf.PdfRenderer(
                ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));

    }
    private void closeRenderer() throws IOException {

        mPdfRenderer.close();

    }

    private void convertImageToBitmap() {

        long start = System.currentTimeMillis();

        //All page convert to bitmap type.
        for (int i = 0; i < mPdfRenderer.getPageCount(); i++) {
            // Use `openPage` to open a specific page in PDF.
            mCurrentPage = mPdfRenderer.openPage(i);

            // Important: the destination bitmap must be ARGB (not RGB).
            bitmap.add(Bitmap.createBitmap(mCurrentPage.getWidth(), mCurrentPage.getHeight(),
                    Bitmap.Config.ARGB_8888));

            // Here, we render the page onto the Bitmap.
            // To render a portion of the page, use the second and third parameter. Pass nulls to get
            // the default result.
            // Pass either RENDER_MODE_FOR_DISPLAY or RENDER_MODE_FOR_PRINT for the last parameter.
            mCurrentPage.render(bitmap.get(i), null, null, android.graphics.pdf.PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
            mCurrentPage.close();
        }

        long end = System.currentTimeMillis();

        Log.d("time", "convertImageToBitmap(), convert pdf file : " + (end - start) / 1000.0);


    }

}
