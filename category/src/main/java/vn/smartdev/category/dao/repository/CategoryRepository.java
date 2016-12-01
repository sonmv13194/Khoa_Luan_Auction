package vn.smartdev.category.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smartdev.category.dao.entity.Category;

import java.util.List;

/**
 * Created by Nhat on 28/11/2016.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,String>{
}
