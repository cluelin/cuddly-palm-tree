package com.purelink.cluelin.catalog.Category;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by cluelin on 2016-12-21.
 */

public class Category implements Parcelable{

    private String categoryName;
    private String pdfFileName;

    private ArrayList<String> subCategoryList = new ArrayList<>();
    private ArrayList<Integer> indexPageList = new ArrayList<>();


    public int startPage;
    public int endPage;

    boolean isNoSubCategory = false;

    public Category() {

    }

    public boolean isNoSubCategory() {
        return isNoSubCategory;
    }

    public void setNoSubCategory(boolean noSubCategory) {
        isNoSubCategory = noSubCategory;
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

    public ArrayList<Integer> getIndexPageList() {
        return indexPageList;
    }

    public void setIndexPageList(ArrayList indexPageList) {
        this.indexPageList = indexPageList;
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


    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel out, int flags) {


        out.writeStringArray(new String[]{getCategoryName(), getPdfFileName()});
        out.writeSerializable(subCategoryList);
        out.writeSerializable(indexPageList);
        out.writeInt(startPage);
        out.writeInt(endPage);
        out.writeByte((byte) (isNoSubCategory ? 1 : 0));
    }

    private Category(Parcel in) {

        String[] strings = new String[2];

        in.readStringArray(strings);

        setCategoryName(strings[0]);
        setPdfFileName(strings[1]);

        setSubCategoryList((ArrayList) in.readSerializable());
        setIndexPageList((ArrayList) in.readSerializable());

        setStartPage(in.readInt());
        setEndPage(in.readInt());


        if (in.readByte() == 1){
            setNoSubCategory(true);
        }


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
