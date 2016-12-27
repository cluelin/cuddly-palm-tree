package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryCable extends Category {

    public CategoryCable(){

        setCategoryName("Cable");
        setPdfFileName(INDEX_SELECTION.CABLE);

        getSubCategoryList().add("CX Series");
        getSubCategoryList().add("EZ Series");
        getSubCategoryList().add("PI Series");
        getSubCategoryList().add("PS Series");
    }
}
