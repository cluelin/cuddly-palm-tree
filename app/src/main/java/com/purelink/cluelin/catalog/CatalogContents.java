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
            String pdfNameString = intent.getStringExtra(INDEX_SELECTION.CONTENTS_SELECTOR);

            //add pdfNameString to bundle object
            Bundle pdfNameBundle = new Bundle();
            pdfNameBundle.putString("PDF_NAME_IN_ASSET", pdfNameString);

            //send bundle object to PdfRenderer, which is Fragment.
            PdfRenderer pdfRenderer = new PdfRenderer();
            pdfRenderer.setArguments(pdfNameBundle);


            getFragmentManager().beginTransaction()
                    .add(R.id.container, pdfRenderer)
                    .commit();
        }
    }

}
