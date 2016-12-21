package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryExtender extends Category {
    private ArrayList arrayList = new ArrayList<String>();

    public CategoryExtender(){

        arrayList.add("HDMI");
        arrayList.add("DVI");
        arrayList.add("HDBaseT");
        arrayList.add("Fiber Optic");

        setCategoryName("Extender");
        setPdfFileName(INDEX_SELECTION.EXTENDER);
        setSubCategoryList(arrayList);
    }
}
