package vn.smartdev.product.services;

import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductModel;

import java.util.List;

/**
 * Created by Nhat on 03/12/2016.
 */
public interface ProductImageServices {
    List<ProductImage> getListProductImage();
    ProductImage getProductImage(String id);
    void saveProductImage(ProductImage productImage);
    void deleteProductImage(String id);
    boolean uploadFile(ProductModel productModel);
}
