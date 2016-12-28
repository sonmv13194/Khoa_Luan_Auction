package vn.smartdev.product.dao.manager;

import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductDetailModel;
import vn.smartdev.product.dao.model.ProductModel;

import java.util.List;

/**
 * Created by Nhat on 28/12/2016.
 */
public interface ProductDetailManager {
    public List<ProductDetail> getListProductDetail();
    public ProductDetail getProductDetail(String id);
    public void deleteProductDetail(String id);
    public void saveProductDetail(ProductDetail productDetail);
    public boolean createProductDetail(ProductModel productModel);
    public boolean updateProductDetail(ProductDetailModel productDetailModel);

    public List<ProductDetail> findTop6ByOrderByCreateByDesc();
    public List<ProductDetail> findTop6ByOrderByProductDetailPriceDesc();
    public List<ProductDetail> findTop3ByOrderByProductDetailPriceAsc() ;
    public List<ProductDetail> findTop8ByOrderByCreateByAsc() ;
    public List<ProductDetail> findByOrderByProductDetailPriceAsc();
    public List<ProductDetail> findByOrderByProductDetailPriceDesc();
    public List<ProductDetail> getListProductDetailByProduct(String productId);
}
