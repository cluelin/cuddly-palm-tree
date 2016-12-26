package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CatalogContents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_contents);

        //저장된 state가 있으면 불러오는거 같은데, 이부분 잘 모르겠음.
        if (savedInstanceState == null) {

            Intent intent = getIntent();

            //get pdf name, from main Activity.
            String pdfNameString = intent.getStringExtra(INDEX_SELECTION.PDF_NAME);
            int targetPage = intent.getIntExtra(INDEX_SELECTION.TARGET_PAGE, 0 );

            //add pdfNameString to bundle object
            Bundle pdfNameBundle = new Bundle();

            pdfNameBundle.putString("PDF_NAME_IN_ASSET", pdfNameString);
            pdfNameBundle.putInt("PDF_PAGE_IN_ASSET", targetPage);

            //send bundle object to PdfRenderingPage which is rendering PdfPage to bitmap
            PdfRenderingPage pdfRendererPage = new PdfRenderingPage();
            pdfRendererPage.setArguments(pdfNameBundle);


            //pdfRendererPage is subClass of Fragment
            //add pdfRederer to container.
            getFragmentManager().beginTransaction()
                    .add(R.id.container, pdfRendererPage)
                    .commit();
        }
    }

}
