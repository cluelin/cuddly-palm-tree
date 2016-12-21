package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryConverter extends Category {

    private ArrayList arrayList = new ArrayList<String>();

    public CategoryConverter(){

        arrayList.add("no list");

        setCategoryName("Converter");
        setPdfFileName(INDEX_SELECTION.CONVERTER);
        setSubCategoryList(arrayList);
    }
}
