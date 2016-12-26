package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.purelink.cluelin.catalog.Category.Category;

import java.util.ArrayList;


public class IndexActivity extends AppCompatActivity implements View.OnClickListener {


    private Category category;
    private TextView majorCategoryNameTextView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //set Category's Title.
        majorCategoryNameTextView = (TextView) findViewById(R.id.majorCategoryNameTextView);
        linearLayout = (LinearLayout) findViewById(R.id.activity_index);

        //get Category Type from Intent
        Intent intent = getIntent();
        category = intent.getParcelableExtra(INDEX_SELECTION.PDF_NAME);

        Log.d("확인차원", "Name : " + category.getCategoryName());
        Log.d("확인차원", "subCategory List : " + category.getSubCategoryList().get(0));

        setIndexPage();

    }

    public void setIndexPage() {


        ArrayList subCategoryList;

        //set MajorCategory index
        majorCategoryNameTextView.setText(category.getCategoryName());
        subCategoryList = category.getSubCategoryList();

        //set SubCategory index.
        for (int i = 0; i < subCategoryList.size(); i++) {
            CustomButton button = new CustomButton(this);
            button.setText((String) subCategoryList.get(i));
            button.setOnClickListener(this);
            button.setTextSize(20);

            linearLayout.addView(button);

        }

    }


    //when each subCategory clicked.
    public void onClick(View v) {

        Intent intent = new Intent(this, CatalogContents.class);
        intent.putExtra(INDEX_SELECTION.PDF_NAME, category.getPdfFileName());

        //here should be implement.
        //send target pdf page
        intent.putExtra(INDEX_SELECTION.PDF_PAGE, 10);

        startActivity(intent);

    }

}
