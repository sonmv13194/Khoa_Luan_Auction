package vn.smartdev.category.dao.model;

import java.io.Serializable;

/**
 * Created by XuanVinh on 12/28/2016.
 */
public class CategoryModel implements Serializable {
    private String id;
    private String name;

    public CategoryModel() {
    }

    public CategoryModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
