package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, INDEX_SELECTION.EXTENDER);
                break;
            case R.id.indexButtonSwitcher:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, INDEX_SELECTION.SWITCHER);
                break;
            case R.id.indexButtonConverter:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, INDEX_SELECTION.CONVERTER);
                break;
            case R.id.indexButtonCable:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, INDEX_SELECTION.CABLE);
                break;
            case R.id.indexButtonSolution:
                intent.putExtra(INDEX_SELECTION.CONTENTS_SELECTOR, INDEX_SELECTION.SOLUTION);
                break;

        }

        startActivity(intent);


    }


}
