package vn.smartdev.product.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.product.dao.entity.Product;

/**
 * Created by Nhat on 29/11/2016.
 */
public interface ProductRepository extends JpaRepository<Product,String>{
}
