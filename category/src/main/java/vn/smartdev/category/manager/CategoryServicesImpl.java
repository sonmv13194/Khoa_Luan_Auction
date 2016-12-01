package vn.smartdev.category.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.repository.CategoryRepository;
import vn.smartdev.category.manager.CategoryServices;


import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryServices{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(String id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.delete(id);

    }
}
