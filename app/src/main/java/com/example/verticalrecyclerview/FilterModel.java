package com.example.verticalrecyclerview;

public class FilterModel {
    String filterName;
    int image;

    public FilterModel(String filterName, int image) {
        this.filterName = filterName;
        this.image = image;
    }

    public String getFilterName() {
        return filterName;
    }

    public int getImage() {
        return image;
    }
}
