package com.purelink.cluelin.catalog;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by cluelin on 2017-01-04.
 */

public class CatalogPDF {

    Activity mActivity;

    private static String PDF_NAME_IN_ASSET;
    private static String PDF_NAME_IN_DEVICE;

    public static ArrayList<Bitmap> bitmap = new ArrayList<>();

    private android.graphics.pdf.PdfRenderer mPdfRenderer;
    private android.graphics.pdf.PdfRenderer.Page mCurrentPage;

    public CatalogPDF(Activity activity){
        this.mActivity = activity;

        PDF_NAME_IN_DEVICE = PDF_NAME_IN_ASSET = INDEX_SELECTION.FULL_PDF;

        try {
            openRenderer(activity);

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(activity, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            activity.finish();
        }

    }

    private void openRenderer(Context context) throws IOException {


        File file = new File(mActivity.getFilesDir().getPath() + "/" + PDF_NAME_IN_DEVICE);
        if (!file.exists()) {

            long start = System.currentTimeMillis();
            CopyReadAssets();
            long end = System.currentTimeMillis();

            Log.d("time", "CopyReadAssets(), load pdf file : " + (end - start)/1000.0);
        }
        Log.d("timeStamp", "파일 패스 : " + mActivity.getCacheDir().getPath() + "/" + PDF_NAME_IN_DEVICE);
        mPdfRenderer = new android.graphics.pdf.PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));


    }

    public void convertToBitmap(int targetPage, int bitmapTargetPage) {



        mCurrentPage = mPdfRenderer.openPage(targetPage);


        Log.d("태그", "PDF targetPage : " + targetPage);

        bitmap.set(bitmapTargetPage, Bitmap.createBitmap(mCurrentPage.getWidth(), mCurrentPage.getHeight(),
                Bitmap.Config.ARGB_8888));

        Log.d("태그", "bitmap targetPage 페이지 : " + bitmapTargetPage);

        mCurrentPage.render(bitmap.get(bitmapTargetPage), null, null, android.graphics.pdf.PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);


        mCurrentPage.close();


//        mPdfRenderer.close();



    }

    private void CopyReadAssets() {
        AssetManager assetManager = mActivity.getAssets();

        InputStream in = null;
        OutputStream out = null;

        File file;

        while (true) {

            //디렉토리에 있는 PDF_NAME_IN_DEVICE 파일을 찾아서
            file = new File(mActivity.getFilesDir(), PDF_NAME_IN_DEVICE);

            Log.d("timeStamp", "파일 패스 : " + file.getAbsolutePath());

            if (file.exists()) {
                Log.d("timeStamp", PDF_NAME_IN_DEVICE + " 파일 존재");
                PDF_NAME_IN_DEVICE = new Random().nextInt() + ".pdf";
                Log.d("timeStamp", "파일 이름 변경 : " + PDF_NAME_IN_DEVICE);

            } else
                break;
        }


        try {
            Log.d("timeStamp", "에셋 파일 갈아타기 시도. " + file.getName());

            in = assetManager.open(PDF_NAME_IN_ASSET);

            Log.d("timeStamp", "에셋 파일 읽기 성공");
            out = mActivity.openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

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
}
