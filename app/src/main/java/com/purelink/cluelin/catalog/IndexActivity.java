package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class IndexActivity extends AppCompatActivity {

    String majorCategoryNameString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        TextView majorCategoryNameTextView = (TextView) findViewById(R.id.majorCategoryNameTextView);

        Intent intent = getIntent();

        //get pdf name, from main Activity.
        majorCategoryNameString = intent.getStringExtra(PdfRenderer.CONTENTS_SELECTOR);
        majorCategoryNameTextView.setText(majorCategoryNameString);


    }


    public void onClick(View v){

        Intent intent = new Intent(this, CatalogContents.class);

        switch (majorCategoryNameString){
            case MainActivity.MATRIXT:
                break;
            case MainActivity.PRESENTATION:
                break;
            case MainActivity.EXTENDER:
                break;
            case MainActivity.SWITCHER:
                break;
            case MainActivity.CONVERTER:
                break;
            case MainActivity.CABLE:
                break;
            case MainActivity.SOLUTION:
                break;
        }

        intent.putExtra(MainActivity.CONTENTS_SELECTOR, majorCategoryNameString);

        startActivity(intent);

    }

}
