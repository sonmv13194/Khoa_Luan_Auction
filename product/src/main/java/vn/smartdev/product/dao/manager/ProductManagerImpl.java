package vn.smartdev.product.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.repository.CategoryRepository;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.dao.repository.ProductDetailRepository;
import vn.smartdev.product.dao.repository.ProductImageRepository;
import vn.smartdev.product.dao.repository.ProductRepository;
import vn.smartdev.product.exception.ProductAlreadyException;
import vn.smartdev.product.exception.ProductNotFoundException;

import java.util.List;

/**
 * Created by Nhat on 26/12/2016.
 */
@Component
public class ProductManagerImpl implements ProductManager{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public List<Product> getListProduct() {
        return productRepository.findAll();
    }
    @Override
    public Product getProduct(String id) {
        return productRepository.findOne(id);
    }
    @Override
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    @Override
    public void deleteProduct(String id) {
        productRepository.delete(id);
    }
}
