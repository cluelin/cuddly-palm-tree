package com.purelink.cluelin.catalog;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.purelink.cluelin.catalog.Library.PhotoView;
import com.purelink.cluelin.catalog.Library.PhotoViewAttacher;

import java.io.File;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by cluelin on 2016-12-07.
 */

public class PdfRenderingPage extends Fragment {


    private static final String STATE_CURRENT_PAGE_INDEX = "current_page_index";
    private static String PDF_NAME_IN_ASSET;
    private static String PDF_NAME_IN_DEVICE;
    private static Boolean FlagForBitmap = false;

    public static ArrayList<Bitmap> bitmap = new ArrayList<>();


    private android.graphics.pdf.PdfRenderer mPdfRenderer;
    private android.graphics.pdf.PdfRenderer.Page mCurrentPage;

    private int targetPage;

    public PdfRenderingPage() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        //activity send PDF_NAME_IN_ASSET in Bundle object.
        PDF_NAME_IN_ASSET = getArguments().getString("PDF_NAME_IN_ASSET");
        targetPage = getArguments().getInt("PDF_PAGE_IN_ASSET");
        PDF_NAME_IN_DEVICE = PDF_NAME_IN_ASSET;

        Log.d("timeStamp", "PDF_NAME_IN_ASSET : " + PDF_NAME_IN_ASSET);


//        try {
//            openRenderer(activity);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(activity, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
//            activity.finish();
//        }

    }


    @Override
    public void onDetach() {
//        try {
//            closeRenderer();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_pdf_renderer_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Show the first page by default.
        int index = 0;
        // If there is a savedInstanceState (screen orientations, etc.), we restore the page index.
        if (null != savedInstanceState) {
            index = savedInstanceState.getInt(STATE_CURRENT_PAGE_INDEX, 0);
        }

        Log.d("timeStamp", "showPage 호출 직전");

        //To converting ViewPager type.
        if (bitmap == null) {
//            convertImageToBitmap();
        }

        bitmap = LogoActivity.bitmap;
        ViewPager mViewPager = (HackyViewPager) view.findViewById(R.id.view_pager);


        mViewPager.setAdapter(new SamplePagerAdapter());
        mViewPager.setCurrentItem(targetPage);

    }

    static class SamplePagerAdapter extends PagerAdapter {



        @Override
        public int getCount() {
            return bitmap.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            photoView.setImageBitmap(bitmap.get(position));

            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (null != mCurrentPage) {
            outState.putInt(STATE_CURRENT_PAGE_INDEX, mCurrentPage.getIndex());
        }
    }

    private void openRenderer(Context context) throws IOException {


//try to use Asset file without copy.
        /*AssetManager assetManager = getActivity().getAssets();
        File file = new File("android.resource://" + getActivity().getPackageName() + "/raw/"+PDF_NAME_IN_ASSET);

        mPdfRenderer = new android.graphics.pdf.PdfRenderingPage(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));
        try {
            ParcelFileDescriptor.fromFd(assetManager.openFd(PDF_NAME_IN_ASSET));
        }*/


        //this is working.
        //copy pdf file from asset to sd card.
        File file = new File(getActivity().getFilesDir().getPath() + "/" + PDF_NAME_IN_DEVICE);

        Log.d("timeStamp", "파일 패스 : " + getActivity().getCacheDir().getPath() + "/" + PDF_NAME_IN_DEVICE);
        mPdfRenderer = new android.graphics.pdf.PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));

//        this is original code. but doesn't work.
        /*mFileDescriptor = context.getAssets().openFd(PDF_NAME_IN_ASSET).getParcelFileDescriptor();
        mPdfRenderer = new android.graphics.pdf.PdfRenderingPage(mFileDescriptor);*/

        //change pdf file location to res/raw. but doesn't work.
        /*Resources res = context.getResources();
        mFileDescriptor = res.openRawResourceFd(R.raw.matrix_catalog).getParcelFileDescriptor();
        mPdfRenderer = new android.graphics.pdf.PdfRenderingPage(mFileDescriptor);*/


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

        FlagForBitmap = true;

    }


}
