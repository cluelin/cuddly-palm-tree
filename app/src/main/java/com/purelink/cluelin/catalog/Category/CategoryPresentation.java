package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryPresentation extends Category{

    private ArrayList arrayList = new ArrayList<String>();

    public CategoryPresentation(){

        arrayList.add("no list");

        setCategoryName("Presentation");
        setPdfFileName(INDEX_SELECTION.PRESENTATION);
        setSubCategoryList(arrayList);
        getIndexPageList().add(0);
    }

}
