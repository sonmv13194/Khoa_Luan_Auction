package vn.smartdev.product.services;

import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.model.ProductDetailModel;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.exception.ProductNotFoundException;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
public interface ProductDetailServices {
    List<ProductDetail> getListProductDetail();
    ProductDetail getProductDetail(String id);
    void deleteProductDetail(String id);
    void saveProductDetail(ProductDetail productDetail);
    void createProductDetail(ProductModel productModel);
    void updateProductDetail(ProductDetailModel productDetailModel);
    List<ProductDetail> getListProductDetailByProduct(String productId);

    //select view
    List<ProductDetail> findTop8ByOrderByCreateByAsc();
    List<ProductDetail> findTop6ByOrderByCreateByDesc();

    List<ProductDetail> findTop3ByOrderByProductDetailPriceAsc();
    List<ProductDetail> findTop6ByOrderByProductDetailPriceDesc();

    List<ProductDetail> findByOrderByProductDetailPriceAsc();
    List<ProductDetail> findByOrderByProductDetailPriceDesc();



}
