package vn.smartdev.product.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;

import java.util.Date;
import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */

public interface ProductDetailRepository extends JpaRepository<ProductDetail,String>{
    public List<ProductDetail> findTop6ByOrderByCreateByDesc();
    public List<ProductDetail> findTop6ByOrderByProductDetailPriceDesc();
    public List<ProductDetail> findTop3ByOrderByProductDetailPriceAsc();
    public List<ProductDetail> findTop8ByOrderByCreateByAsc();
    public List<ProductDetail> findByOrderByProductDetailPriceAsc();
    public List<ProductDetail> findByOrderByProductDetailPriceDesc();
//    @Query("select p from ProductDetail p where p.productDetailPrice = :productDetailPrice or p.supplyer = :supplyer")
//    public List<ProductDetail> findByProductDetailPriceOrSupplyer(@Param("productDetailPrice") String productDetalPrice,@Param("supplyer") String supplyer);
    //test
    List<ProductDetail> findFirstByProductIdAndCreatedGreaterThanOrderByCreatedDesc(String createBy,Date create);
    List<ProductDetail> findBySupplyerOrderByProductIdAscProductDetailQuantityAsc(String suppler);
    List<ProductDetail> findBySupplyerOrderByProductAscProductDetailQuantityAsc(String suppler);
    //Test Query
    @Query("from ProductDetail p where p.supplyer =:supplyer order by p.product asc,p.productDetailQuantity asc")
    List<ProductDetail> demoQuery(@Param("supplyer") String supplyer);
    //test query
//    @Query("select p  ")
//    List<ProductDetail> testQuery(String createBy,Date create);

}

