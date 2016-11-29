package vn.smartdev.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.repository.ProductRepository;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
public class ProductServicesImpl implements ProductServices{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getListProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.delete(id);
    }
}
