package vn.smartdev.category.dao.manager;

import vn.smartdev.category.dao.entity.Category;

import java.util.List;

/**
 * Created by XuanVinh on 12/28/2016.
 */
public interface CategoryManager {
    List<Category> getListCategory();
    Category getCategory(String id);
    void saveCategory(Category category);
    void deleteCategory(String id);
}
