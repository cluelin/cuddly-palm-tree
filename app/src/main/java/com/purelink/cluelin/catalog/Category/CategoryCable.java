package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryCable extends Category {

    private ArrayList arrayList = new ArrayList<String>();

    public CategoryCable(){

        arrayList.add("CX Series");
        arrayList.add("EZ Series");
        arrayList.add("PI Series");
        arrayList.add("PS Series");

        setCategoryName("Cable");
        setPdfFileName(INDEX_SELECTION.CABLE);
        setSubCategoryList(arrayList);
    }
}
