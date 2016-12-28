package vn.smartdev.category.services;

import vn.smartdev.category.dao.entity.Category;

import java.util.List;

/**
 * Created by XuanVinh on 12/28/2016.
 */
public interface CategoryServices {
    List<Category> getListCategory();
    Category getCategory(String id);
    void saveCategory(Category category);
    void deleteCategory(String id);
}
