package vn.smartdev.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.repository.CategoryRepository;
import vn.smartdev.product.dao.entity.Product;
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

//    @Override
//    public List<Product> viewListProduct(List<Product> getListProduct) {
//        List<Product> listProduct = new ArrayList<Product>();
//        for(int i = 0 ; i < getListProduct.size() ; i++)
//        {
//            Product product = new Product(getListProduct.get(i).getProductName(),getListProduct.get(i).getDescription(),getListProduct.get(i).getCategory().getCategoryName());
//            listProduct.add(product);
//        }
//        return listProduct;
//    }

    @Override
    public void deleteObjectProduct(Product product) {
        productRepository.delete(product);
    }


    @Override
    public Product createProduct(String productName, String description, String categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        Product product = new Product();
        product.setProductName(productName);
        product.setDescription(description);
//        product.setCategory(category);

        return product;
    }
}
