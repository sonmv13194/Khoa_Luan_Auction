package vn.smartdev.category.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smartdev.category.dao.entity.Category;

/**
 * Created by Nhat on 28/11/2016.
 */
public interface CategoryRepository extends JpaRepository<Category,String>{
}
