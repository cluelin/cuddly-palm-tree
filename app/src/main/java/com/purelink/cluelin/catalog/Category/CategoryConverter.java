package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryConverter extends Category {



    public CategoryConverter(){

        getSubCategoryList().add("no list");
        getIndexPageList().add(72);

        setStartPage(72);
        setEndPage(76);

        setCategoryName("Converter");
        setPdfFileName(INDEX_SELECTION.CONVERTER);

        setNoSubCategory(true);
    }


}
