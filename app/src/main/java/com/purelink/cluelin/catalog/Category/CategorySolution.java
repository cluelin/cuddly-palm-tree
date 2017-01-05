package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategorySolution extends Category {



    public CategorySolution(){

        getSubCategoryList().add("no subcategory");
        getIndexPageList().add(76);

        setCategoryName("Solution");
        setPdfFileName(INDEX_SELECTION.SOLUTION);

    }
}
