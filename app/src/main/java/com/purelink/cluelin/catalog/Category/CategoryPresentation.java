package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryPresentation extends Category {



    public CategoryPresentation(){



        setCategoryName("Presentation");
        setPdfFileName(INDEX_SELECTION.PRESENTATION);
        getSubCategoryList().add("No sub category");

        getIndexPageList().add(28);

        setStartPage(28);
        setEndPage(28);

        setNoSubCategory(true);
    }




}
