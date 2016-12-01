package vn.smartdev.product.manager;

import vn.smartdev.product.dao.entity.ProductDetail;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
public interface ProductDetailServices {
    public List<ProductDetail> getListProductDetail();
    public ProductDetail getProductDetail(String id);
    public double getTotal(String id);
}
