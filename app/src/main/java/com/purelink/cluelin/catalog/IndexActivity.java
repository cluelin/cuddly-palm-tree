package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.purelink.cluelin.catalog.Category.Category;

import java.util.ArrayList;


public class IndexActivity extends AppCompatActivity {

    String majorCategoryNameString;
    private Category category;
    private TextView majorCategoryNameTextView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        majorCategoryNameTextView = (TextView) findViewById(R.id.majorCategoryNameTextView);
        linearLayout = (LinearLayout) findViewById(R.id.activity_index);

        Intent intent = getIntent();

        category = intent.getParcelableExtra(INDEX_SELECTION.CONTENTS_SELECTOR);

        Log.d("확인차원", "Name : " + category.getCategoryName());
        Log.d("확인차원", "subCategory List : " + category.getSubCategoryList().get(0));

        setIndexPage();

    }

    public void setIndexPage(){

        ArrayList subCategoryList;

        majorCategoryNameTextView.setText(category.getCategoryName());
        subCategoryList = category.getSubCategoryList();

        for (int i = 0 ; i < subCategoryList.size() ; i++ ){
            Button button = new Button(this);
            button.setText((String)subCategoryList.get(i));
            linearLayout.addView(button);

        }

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
