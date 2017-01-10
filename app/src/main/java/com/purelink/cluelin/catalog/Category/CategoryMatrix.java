package com.purelink.cluelin.catalog.Category;

import android.util.Log;

import com.purelink.cluelin.catalog.INDEX_SELECTION;
import com.purelink.cluelin.catalog.R;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategoryMatrix extends Category {

    private ArrayList<String> subCategoryList = new ArrayList();


    public CategoryMatrix(){

        setCategoryName("Matrix");

        setPdfFileName(INDEX_SELECTION.MATRIXT);

        makeSubCategoryList();
        setSubCategoryList(subCategoryList);

        makeIndexPageList();

        getButtonImage().add(R.drawable.catalog_2016_icon);

        setStartPage(6);
        setEndPage(25);
    }

    private void makeIndexPageList(){
        getIndexPageList().add(6);
        getIndexPageList().add(14);
        getIndexPageList().add(16);
        getIndexPageList().add(21);
        getIndexPageList().add(23);
        getIndexPageList().add(24);
    }

    private void makeSubCategoryList(){
        subCategoryList.add("PM");
        subCategoryList.add("UX");
        subCategoryList.add("HX");
        subCategoryList.add("HTX");
        subCategoryList.add("MXA");
        subCategoryList.add("MX");


    }


}
