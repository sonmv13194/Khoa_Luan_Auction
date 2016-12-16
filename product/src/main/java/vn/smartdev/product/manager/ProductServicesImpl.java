package vn.smartdev.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean createProduct(ProductModel productModel) {
        try {
            Category category = categoryRepository.findOne(productModel.getCategoryId());

            //Product
            Product product = new Product();
            product.setProductName(productModel.getProductName());
            product.setDescription(productModel.getDescription());
            product.setCategory(category);
            productRepository.save(product);

            //productDetail
            ProductDetail productDetail = new ProductDetail();
            productDetail.setProductDetailCode("1");
            productDetail.setProductDetailStatus(productModel.getProductStatus());
            productDetail.setProductDetailPrice(productModel.getPrice());
            productDetail.setProductDetailQuantity(productModel.getQuantity());
            productDetail.setDescription(productDetail.getDescription());
            productDetail.setSupplyer(productDetail.getSupplyer());
            productDetail.setProduct(product);
            productDetailRepository.save(productDetail);

            //productImage
            ProductImage productImage = new ProductImage();
            productImage.setUrl(productModel.getFile().getOriginalFilename());
            productImage.setProductDetail(productDetail);
            productImageRepository.save(productImage);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }



}
