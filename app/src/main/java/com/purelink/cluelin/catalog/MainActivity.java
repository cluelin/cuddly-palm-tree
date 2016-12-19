package com.purelink.cluelin.catalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Decide which contents open.
    public static final String CONTENTS_SELECTOR = "CONTENTS_SELECTOR";
    public static final String MATRIXT = "matrix_catalog.pdf";
    public static final String PRESENTATION = "presentation_systems.pdf";
    public static final String EXTENDER = "extender.pdf";
    public static final String SWITCHER = "switchers_distribution_amplifiers.pdf";
    public static final String CONVERTER = "format_converters.pdf";
    public static final String CABLE = "cables_accessories.pdf";
    public static final String SOLUTION = "digital_signage_solutions.pdf";

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
                intent.putExtra(CONTENTS_SELECTOR, MATRIXT);
                break;
            case R.id.indexButtonPresentation:
                intent.putExtra(CONTENTS_SELECTOR, PRESENTATION);
                break;
            case R.id.indexButtonExtender:
                intent.putExtra(CONTENTS_SELECTOR, EXTENDER);
                break;
            case R.id.indexButtonSwitcher:
                intent.putExtra(CONTENTS_SELECTOR, SWITCHER);
                break;
            case R.id.indexButtonConverter:
                intent.putExtra(CONTENTS_SELECTOR, CONVERTER);
                break;
            case R.id.indexButtonCable:
                intent.putExtra(CONTENTS_SELECTOR, CABLE);
                break;
            case R.id.indexButtonSolution:
                intent.putExtra(CONTENTS_SELECTOR, SOLUTION);
                break;

        }

        startActivity(intent);


    }


}
