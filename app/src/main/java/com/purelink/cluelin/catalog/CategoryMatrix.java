package com.purelink.cluelin.catalog;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryMatrix extends Category {

    private ArrayList arrayList = new ArrayList<String>();

    public CategoryMatrix(){

        arrayList.add("PM");
        arrayList.add("UX");
        arrayList.add("HX");
        arrayList.add("HTX");
        arrayList.add("MXA");
        arrayList.add("MX");

        setCategoryName("Matrix");

        setPdfFileName(INDEX_SELECTION.MATRIXT);
        setSubCategoryList(arrayList);



    }

}
