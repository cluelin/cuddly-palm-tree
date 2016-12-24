package com.purelink.cluelin.catalog;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * Created by cluelin on 2016-12-22.
 */

public class CustomButton extends Button {

    Context mContext;

    public CustomButton(Context context){
        super(context);

        mContext= context;

        setBackgroundColor(Color.argb(0,0,0,0));
        setBackground(getResources().getDrawable(R.drawable.edge));
//
//        ViewGroup.MarginLayoutParams marginLayoutParams =
//                (ViewGroup.MarginLayoutParams) getLayoutParams();
//        marginLayoutParams.setMargins(10, 10, 10, 10);
//        setLayoutParams(marginLayoutParams);

        //set margin to Button
//        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams();

//        setLayoutParams(marginLayoutParams);

    }
//
//    public void setText(String test){
//
//        TextView textView = new TextView(mContext);
//        textView.setText(test);
//        textView.setTextSize(20);
//        textView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
//
//
//
//        addView(textView);
//    }
}
