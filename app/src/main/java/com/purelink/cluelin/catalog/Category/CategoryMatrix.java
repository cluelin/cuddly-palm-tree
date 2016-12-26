package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryMatrix extends Category {

    private ArrayList<String> subCategoryList = new ArrayList();
    private ArrayList<Integer> indexList = new ArrayList();

    public CategoryMatrix(){

        setCategoryName("Matrix");

        setPdfFileName(INDEX_SELECTION.MATRIXT);

        makeSubCategoryList();
        setSubCategoryList(subCategoryList);

        makeIndexList();
        setIndexPageList(indexList);

    }

    private void makeSubCategoryList(){
        subCategoryList.add("PM");
        subCategoryList.add("UX");
        subCategoryList.add("HX");
        subCategoryList.add("HTX");
        subCategoryList.add("MXA");
        subCategoryList.add("MX");


    }

    private  void makeIndexList(){
        indexList.add(5);
        indexList.add(14);
        indexList.add(16);
        indexList.add(21);
        indexList.add(23);
        indexList.add(24);
    }

}
