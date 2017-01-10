package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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

        Log.d("태그", "Name : " + category.getCategoryName());
        Log.d("태그", "subCategory List : " + category.getSubCategoryList().get(0));
        Log.d("태그", "IndexList : " + category.getIndexPageList().get(0));
        Log.d("태그", "startPage : " + category.getStartPage());



        Log.d("태그", "category.getClass() : " + category.getClass());
        Log.d("태그", "category.isNoSubCategory() : " + category.isNoSubCategory());



        if (category.isNoSubCategory()){

            sendSubCategoryInformation(0);
            finish();

        }else{
            Log.d("태그", "NoSubCategory 의 자손이 아님");
            setIndexPage();
        }


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
            button.setId(i);
            button.setOnClickListener(this);
            button.setTextSize(20);
//            button.setBackground(getDrawable(category.getButtonImage().get(0)));
//            button.setScaleType(ImageView.ScaleType.CENTER);
//            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50));


            linearLayout.addView(button);

        }



    }


    //when each subCategory clicked.
    public void onClick(View v) {

        Log.d("time", "서브 카테고리 클릭됨");

        sendSubCategoryInformation(v.getId());

    }

    public void sendSubCategoryInformation(int SubCategoryOrder){

        Intent intent = new Intent(this, CatalogContents.class);
        intent.putExtra(INDEX_SELECTION.PDF_NAME, category.getPdfFileName());

        //send target pdf page
        //can be improve.
        //but now it works.
        //maybe later..
        intent.putExtra(INDEX_SELECTION.TARGET_PAGE, category.getIndexPageList().get(SubCategoryOrder));
        intent.putExtra(INDEX_SELECTION.START_PAGE, category.getStartPage());
        intent.putExtra(INDEX_SELECTION.END_PAGE, category.getEndPage());

        startActivity(intent);

    }

}
