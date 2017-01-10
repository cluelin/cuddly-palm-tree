package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.NonConfigurationInstance;
import com.googlecode.androidannotations.annotations.OptionsItem;
import com.googlecode.androidannotations.annotations.ViewById;
import com.purelink.cluelin.catalog.pdfview.PDFView;
import com.purelink.cluelin.catalog.pdfview.listener.OnPageChangeListener;


import static java.lang.String.format;


public class CatalogContents extends SherlockActivity implements OnPageChangeListener {


    public static final String SAMPLE_FILE = "sample.pdf";

    public static final String ABOUT_FILE = "about.pdf";

    @ViewById
    PDFView pdfView;

    @NonConfigurationInstance
    String pdfName = SAMPLE_FILE;

    @NonConfigurationInstance
    Integer pageNumber = 1;

    @AfterViews
    void afterViews() {
        display(pdfName, false);
    }

    @OptionsItem
    public void about() {
        if (!displaying(ABOUT_FILE))
            display(ABOUT_FILE, true);
    }

    private void display(String assetFileName, boolean jumpToFirstPage) {
        if (jumpToFirstPage) pageNumber = 1;
        setTitle(pdfName = assetFileName);

        pdfView.fromAsset(assetFileName)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(format("%s %s / %s", pdfName, page, pageCount));
    }

    @Override
    public void onBackPressed() {
        if (ABOUT_FILE.equals(pdfName)) {
            display(SAMPLE_FILE, true);
        } else {
            super.onBackPressed();
        }
    }

    private boolean displaying(String fileName) {
        return fileName.equals(pdfName);
    }

}
