package vn.smartdev.category.manager.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.repository.CategoryRepository;
import vn.smartdev.category.manager.services.CategoryServices;

import java.util.List;

/**
 * Created by Nhat on 28/11/2016.
 */
public class CategoryServicesImpl implements CategoryServices{
    @Autowired
    private CategoryRepository categoryRepository;

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
