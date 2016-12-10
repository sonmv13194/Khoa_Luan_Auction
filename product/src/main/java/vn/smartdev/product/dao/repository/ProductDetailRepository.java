package vn.smartdev.product.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.smartdev.product.dao.entity.ProductDetail;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */

public interface ProductDetailRepository extends JpaRepository<ProductDetail,String>{
    public List<ProductDetail> findTop6ByOrderByCreateByDesc();
    public List<ProductDetail> findTop6ByOrderByProductDetailPriceDesc();
    public List<ProductDetail> findTop3ByOrderByProductDetailPriceAsc();
    public List<ProductDetail> findTop8ByOrderByCreateByAsc();
}

