package vn.smartdev.category.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smartdev.category.dao.entity.Category;


import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryServices {
    @Autowired
    private CategoryServicesImpl categoryManager;

    @Override
    public List<Category> getListCategory() {
        return categoryManager.getListCategory();
    }

    @Override
    public Category getCategory(String id) {
        return categoryManager.getCategory(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryManager.saveCategory(category);
    }

    @Override
    public void deleteCategory(String id) {
        categoryManager.deleteCategory(id);

    }
}
