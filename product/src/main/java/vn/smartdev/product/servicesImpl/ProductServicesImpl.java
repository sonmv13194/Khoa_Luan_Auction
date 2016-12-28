package vn.smartdev.product.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.manager.CategoryManager;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.manager.ProductDetailManager;
import vn.smartdev.product.dao.manager.ProductImageManager;
import vn.smartdev.product.dao.manager.ProductManager;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.services.ProductServices;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    private ProductManager productManager;

    @Autowired
    private ProductDetailManager productDetailManager;

    @Autowired
    private ProductImageManager productImageManager;


    @Autowired
    private CategoryManager categoryManager;

    @Override
    public List<Product> getListProduct() {
        return productManager.getListProduct();
    }

    @Override
    public Product getProduct(String id) {
        return productManager.getProduct(id);
    }

    @Override
    public void saveProduct(Product product) {
        productManager.saveProduct(product);
    }

    @Override
    public void deleteProduct(String id) {
        productManager.deleteProduct(id);
    }

    @Override
    //@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public boolean createProduct(ProductModel productModel) {
        try {
            Category category = categoryManager.getCategory(productModel.getCategoryId());

            //Product
            Product product = new Product();
            product.setProductName(productModel.getProductName());
            product.setDescription(productModel.getDescription());
            product.setCategory(category);
            productManager.saveProduct(product);

            //productDetail
            ProductDetail productDetail = new ProductDetail();
            productDetail.setProductDetailName(productModel.getProductDetailName());
            productDetail.setProductDetailStatus(productModel.getProductStatus());
            productDetail.setProductDetailPrice(productModel.getPrice());
            productDetail.setProductDetailQuantity(productModel.getQuantity());
            productDetail.setDescription(productDetail.getDescription());
            productDetail.setSupplyer(productDetail.getSupplyer());
            productDetail.setProduct(product);
            productDetailManager.saveProductDetail(productDetail);

            //productImage
            ProductImage productImage = new ProductImage();
            productImage.setUrl(productModel.getProductName()+"_"+productModel.getFile().getOriginalFilename());
            productImage.setProductDetail(productDetail);
            productImageManager.saveProductImage(productImage);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }



}
