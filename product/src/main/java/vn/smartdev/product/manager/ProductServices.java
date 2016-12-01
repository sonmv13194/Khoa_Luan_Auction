package vn.smartdev.product.manager;

import vn.smartdev.product.dao.entity.Product;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
public interface ProductServices {
    public List<Product> getListProduct();
    public Product getProduct(String id);
    public void saveProduct(Product product);
    public void deleteProduct(String id);

}
