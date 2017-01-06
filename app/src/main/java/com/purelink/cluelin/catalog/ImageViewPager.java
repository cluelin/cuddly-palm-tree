package com.purelink.cluelin.catalog;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.purelink.cluelin.catalog.Library.PhotoView;

/**
 * Created by cluelin on 2016-12-07.
 */

public class ImageViewPager extends Fragment {

    public static int targetPage;
    public static int startPage;
    public static int endPage;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        startPage = getArguments().getInt(INDEX_SELECTION.START_PAGE);
        endPage  = getArguments().getInt(INDEX_SELECTION.END_PAGE);

        Log.d("태그", "onAttach 호출");

        Log.d("태그", "startPage : " + startPage + " endPage : " + endPage);

        if(CatalogPDF.bitmap.size() < endPage - startPage + 1){

            while (true){
                CatalogPDF.bitmap.add(null);
                Log.d("태그", "bitmap size : " + CatalogPDF.bitmap.size());
                if (CatalogPDF.bitmap.size() >= endPage - startPage + 1){
                    break;
                }
            }
        }


        targetPage = getArguments().getInt("PDF_PAGE_IN_ASSET");
        Log.d("태그", "targetPage : " + targetPage);
        Log.d("태그", "targetPage-startPage : " + targetPage + "-" + startPage);

        long start = System.currentTimeMillis();
        LogoActivity.catalogPDF.convertToBitmap(targetPage, targetPage - startPage);

        long end = System.currentTimeMillis();

        Log.d("태그", "convertToBitmap(), convert pdf file : " + (end - start)/1000.0);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.d("태그", "onDetach 호출");

        CatalogPDF.bitmap.clear();
    }

    public ImageViewPager() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_pdf_renderer_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager mViewPager = (HackyViewPager) view.findViewById(R.id.view_pager);

        mViewPager.setAdapter(new SamplePagerAdapter());

        Log.d("태그", "초기값 호출 타이밍 확인");
        mViewPager.setCurrentItem(targetPage-startPage - 1);

    }

    static class SamplePagerAdapter extends PagerAdapter {

        private boolean doNotifyDataSetChangedOnce = false;

        @Override
        public int getCount() {


            if (doNotifyDataSetChangedOnce) {
                Log.d("태그", "doNotifyDataSetChangeOnce 호출 타이밍 확인");
                doNotifyDataSetChangedOnce = false;
                notifyDataSetChanged();
            }

            return CatalogPDF.bitmap.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {

            doNotifyDataSetChangedOnce = true;

            PhotoView photoView = new PhotoView(container.getContext());

            Log.d("태그", "bitmap size : " + CatalogPDF.bitmap.size());

            if(position <= ImageViewPager.endPage - ImageViewPager.startPage ){
                LogoActivity.catalogPDF.convertToBitmap( position  + startPage , position);
            }


            photoView.setImageBitmap(CatalogPDF.bitmap.get(position));

            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d("태그", "디스트로이 아이템");
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            Log.d("태그", "뷰 프롬 오브젝트");
            return view == object;
        }

    }






}
