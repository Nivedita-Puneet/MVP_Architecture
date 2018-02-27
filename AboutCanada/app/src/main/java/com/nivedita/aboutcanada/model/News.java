package com.nivedita.aboutcanada.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

/**
 * Created by NEETU on 27-02-2018.
 */

/*Object to hold list of categories and News.*/
public class News {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    private List<Category> categories;

    public News(String title, List<Category> categories) {
        this.title = title;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
