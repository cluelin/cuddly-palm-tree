package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.purelink.cluelin.catalog.Category.CategoryCable;
import com.purelink.cluelin.catalog.Category.CategoryConverter;
import com.purelink.cluelin.catalog.Category.CategoryExtender;
import com.purelink.cluelin.catalog.Category.CategoryMatrix;
import com.purelink.cluelin.catalog.Category.CategoryPresentation;
import com.purelink.cluelin.catalog.Category.CategorySolution;
import com.purelink.cluelin.catalog.Category.CategorySwitcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void onClickContentsSelectButton(View view) {

        Intent intent = new Intent(this, IndexActivity.class);

        //send selected pdf name
        switch (view.getId()) {
            case R.id.indexButtonMatrix:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, new CategoryMatrix());
                break;
            case R.id.indexButtonPresentation:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, new CategoryPresentation());
                break;
            case R.id.indexButtonExtender:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, new CategoryExtender());
                break;
            case R.id.indexButtonSwitcher:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, new CategorySwitcher());
                break;
            case R.id.indexButtonConverter:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, new CategoryConverter());
                break;
            case R.id.indexButtonCable:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, new CategoryCable());
                break;
            case R.id.indexButtonSolution:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, new CategorySolution());
                break;

        }

        startActivity(intent);


    }


}
