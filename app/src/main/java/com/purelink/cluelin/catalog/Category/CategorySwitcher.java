package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.Category.Category;
import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategorySwitcher extends Category {



    public CategorySwitcher(){

        getSubCategoryList().add("HDMI");
        getSubCategoryList().add("DVI");

        getIndexPageList().add(62);
        getIndexPageList().add(68);

        setCategoryName("Switcher");
        setPdfFileName(INDEX_SELECTION.SWITCHER);

    }

}
