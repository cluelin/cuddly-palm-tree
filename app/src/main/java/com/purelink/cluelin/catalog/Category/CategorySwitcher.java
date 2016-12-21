package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.Category.Category;
import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategorySwitcher extends Category {

    private ArrayList arrayList = new ArrayList<String>();

    public CategorySwitcher(){

        arrayList.add("HDMI");
        arrayList.add("DVI");

        setCategoryName("Switcher");
        setPdfFileName(INDEX_SELECTION.SWITCHER);
        setSubCategoryList(arrayList);
    }

}
