package com.purelink.cluelin.catalog.Category;

import com.purelink.cluelin.catalog.INDEX_SELECTION;

/**
 * Created by cluelin on 2016-12-21.
 */

public class CategorySolution extends Category {



    public CategorySolution(){

        getSubCategoryList().add("no subcategory");
        getIndexPageList().add(78);

        setStartPage(78);
        setEndPage(79);
        setCategoryName("Solution");
        setPdfFileName(INDEX_SELECTION.SOLUTION);

        setNoSubCategory(true);

    }

}
