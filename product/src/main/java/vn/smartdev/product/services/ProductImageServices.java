package vn.smartdev.product.services;

import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductModel;

import java.util.List;

/**
 * Created by Nhat on 03/12/2016.
 */
public interface ProductImageServices {
    public List<ProductImage> getListProductImage();
    public ProductImage getProductImage(String id);
    public void savePorductImage(ProductImage productImage);
    public void deleteProductImage(String id);
    public boolean uploadFile(ProductModel productModel);
}
