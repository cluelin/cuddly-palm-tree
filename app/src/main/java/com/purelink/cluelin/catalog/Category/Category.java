package com.purelink.cluelin.catalog.Category;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class Category implements Parcelable {

    private String categoryName;
    private String pdfFileName;

    private ArrayList subCategoryList;
    private ArrayList subCategoryIndexPageList;

    private int startPage;


    public Category() {

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }

    public void setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }

    public ArrayList getSubCategoryIndexPageList() {
        return subCategoryIndexPageList;
    }

    public void setSubCategoryIndexPageList(ArrayList subCategoryIndexPageList) {
        this.subCategoryIndexPageList = subCategoryIndexPageList;
    }

    public ArrayList getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(ArrayList subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel out, int flags) {


        out.writeStringArray(new String[]{getCategoryName(), getPdfFileName()});
        out.writeSerializable(subCategoryList);
        out.writeSerializable(subCategoryIndexPageList);
    }

    private Category(Parcel in) {

        String[] strings = new String[2];

        in.readStringArray(strings);

        setCategoryName(strings[0]);
        setPdfFileName(strings[1]);

        setSubCategoryList((ArrayList) in.readSerializable());
        setSubCategoryIndexPageList((ArrayList) in.readSerializable());


    }


    public static final Parcelable.Creator<Category> CREATOR
            = new Parcelable.Creator<Category>() {
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        public Category[] newArray(int size) {
            return new Category[size];
        }
    };


}
