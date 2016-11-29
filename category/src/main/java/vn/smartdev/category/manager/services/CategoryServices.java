package vn.smartdev.category.manager.services;

import vn.smartdev.category.dao.entity.Category;

import java.util.List;

/**
 * Created by Nhat on 28/11/2016.
 */
public interface CategoryServices {
    public List<Category> getListCategory();
    public Category getCategory(String id);
    public void saveCategory(Category category);
    public void deleteCategory(String id);
}
