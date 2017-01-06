package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryExtender extends Category {


    public CategoryExtender(){

        getSubCategoryList().add("HDMI");
        getSubCategoryList().add("DVI");
        getSubCategoryList().add("HDBaseT");
        getSubCategoryList().add("Fiber Optic");

        getIndexPageList().add(32);
        getIndexPageList().add(40);
        getIndexPageList().add(42);
        getIndexPageList().add(49);

        setStartPage(32);
        setEndPage(60);

        setCategoryName("Extender");
        setPdfFileName(INDEX_SELECTION.EXTENDER);

    }
}
