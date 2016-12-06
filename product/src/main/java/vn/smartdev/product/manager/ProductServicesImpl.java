package vn.smartdev.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.repository.CategoryRepository;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.dao.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
@Service
public class ProductServicesImpl implements ProductServices{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

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

    @Override
    public void deleteObjectProduct(Product product) {
        productRepository.delete(product);
    }


    @Override
    public Product createProduct(String categoryId,ProductModel productModel) {
        Category category = categoryRepository.findOne(categoryId);
        Product product = new Product();
        product.setProductName(productModel.getProductName());
        product.setDescription(productModel.getDescription());
        //tam thoi chua fix dc loi~ nay
//        product.setCategory(category);
        return product;
    }

    @Override
    public Product createProductDetail(String categoryId, String checkProductId,ProductModel productModel) {

        Category category = categoryRepository.findOne(categoryId);
        Product product = new Product();
        product.setId(checkProductId);
        product.setProductName(productModel.getProductName());
        product.setDescription(productModel.getDescription());
        //tam thoi chua fix dc loi~ nay
//        product.setCategory(category);
        return product;
    }
}
