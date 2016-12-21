package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;


public class IndexActivity extends AppCompatActivity {

    String majorCategoryNameString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        TextView majorCategoryNameTextView = (TextView) findViewById(R.id.majorCategoryNameTextView);

        Intent intent = getIntent();

        //get pdf name, from main Activity.
//        majorCategoryNameString = intent.getStringExtra(INDEX_SELECTION.CONTENTS_SELECTOR);
//        majorCategoryNameTextView.setText(majorCategoryNameString);

        Category category = (Category)intent.getParcelableExtra(INDEX_SELECTION.CONTENTS_SELECTOR);

        Log.d("확인차원", "Name : " + category.getCategoryName());
        Log.d("확인차원", "subCategory List : " + category.getSubCategoryList().get(0));




    }


    public void onClick(View v){

        Intent intent = new Intent(this, CatalogContents.class);

        switch (majorCategoryNameString){
            case INDEX_SELECTION.MATRIXT:
                break;
            case INDEX_SELECTION.PRESENTATION:
                break;
            case INDEX_SELECTION.EXTENDER:
                break;
            case INDEX_SELECTION.SWITCHER:
                break;
            case INDEX_SELECTION.CONVERTER:
                break;
            case INDEX_SELECTION.CABLE:
                break;
            case INDEX_SELECTION.SOLUTION:
                break;
        }

        intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, majorCategoryNameString);

        startActivity(intent);

    }

}
