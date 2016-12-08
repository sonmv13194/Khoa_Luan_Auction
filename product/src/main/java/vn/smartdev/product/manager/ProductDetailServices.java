package vn.smartdev.product.manager;

import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.model.ProductDetailModel;
import vn.smartdev.product.dao.model.ProductModel;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
public interface ProductDetailServices {
    public List<ProductDetail> getListProductDetail();
    public ProductDetail getProductDetail(String id);
    public double getTotal(String id);
    public void deleteProductDetail(String id);
    public void saveProductDetail(ProductDetail productDetail);
    public boolean createProductDetail(ProductModel productModel);
    public boolean updateProductDetail(ProductDetailModel productDetailModel);
}
