package vn.smartdev.product.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smartdev.product.dao.entity.ProductDetail;

/**
 * Created by Nhat on 29/11/2016.
 */

public interface ProductDetailRepository extends JpaRepository<ProductDetail,String>{
}
