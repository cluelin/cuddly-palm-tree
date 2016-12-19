package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Decide which contents open.
    public static final String CONTENTS_SELECTOR = "CONTENTS_SELECTOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void onClickContentsSelectButton(View view) {

        Intent intent = new Intent(this, CatalogContents.class);

        //send selected pdf name
        switch (view.getId()) {
            case R.id.indexButtonMatrix:
                intent.putExtra(CONTENTS_SELECTOR, "matrix_catalog.pdf");
                break;
            case R.id.indexButtonPresentation:
                intent.putExtra(CONTENTS_SELECTOR, "presentation_systems.pdf");
                break;
            case R.id.indexButtonExtender:
                intent.putExtra(CONTENTS_SELECTOR, "extender.pdf");
                break;
            case R.id.indexButtonSwitcher:
                intent.putExtra(CONTENTS_SELECTOR, "switchers_distribution_amplifiers.pdf");
                break;
            case R.id.indexButtonConverter:
                intent.putExtra(CONTENTS_SELECTOR, "format_converters.pdf");
                break;
            case R.id.indexButtonCable:
                intent.putExtra(CONTENTS_SELECTOR, "cables_accessories.pdf");
                break;
            case R.id.indexButtonSolution:
                intent.putExtra(CONTENTS_SELECTOR, "digital_signage_solutions.pdf");
                break;

        }

        startActivity(intent);


    }


}
