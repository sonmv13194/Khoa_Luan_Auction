package vn.smartdev.product.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.manager.CategoryManager;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.manager.ProductDetailManager;
import vn.smartdev.product.dao.manager.ProductImageManager;
import vn.smartdev.product.dao.manager.ProductManager;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.exception.*;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
@Service
public class ProductServicesImpl implements ProductServices {
    private static final Logger logger = LoggerFactory.getLogger(ProductServicesImpl.class);

    @Autowired
    private ProductManager productManager;

    @Autowired
    private ProductDetailManager productDetailManager;

    @Autowired
    private ProductImageManager productImageManager;


    @Autowired
    private CategoryManager categoryManager;

    @Override
    public List<Product> getListProduct()  {
        List<Product> listProduct = null;
        try
        {
            listProduct = productManager.getListProduct();
        } catch (ProductNotFoundException e) {
            logger.error("getListProduct not foud : "+e.getMessage());
        }
        return listProduct;
    }

    @Override
    public Product getProduct(String id) {
        Product product = null;
        try {
            product = productManager.getProduct(id);
        } catch (ProductNotFoundException e) {
            logger.error("getProduct not found : "+e.getMessage());
        }
        return product;
    }

    @Override
    public void deleteProduct(String id){
        try {
            productManager.deleteProduct(id);
        } catch (ProductNotFoundException e) {
            logger.error("deleteProduct failed :"+e.getMessage());
        }

    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void createProduct(ProductModel productModel) {
        try {
            Category category = categoryManager.getCategory(productModel.getCategoryId());

            //checkNameProduct
            checkNameProduct(productModel.getProductName());

            //Product
            Product product = new Product();
            product.setProductName(productModel.getProductName());
            product.setDescription(productModel.getDescription());
            product.setCategory(category);
            productManager.saveProduct(product);

            //checkNameProductDetail
            checkNameProductDetail(productModel.getProductDetailName());

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
        }
        catch (ProductAlreadyException | ProductDetailAlreadyException | ProductImageAlreadyException e)
        {
            logger.error("saveProduct failed :"+e.getMessage());
            logger.error("saveProductDetail failed :"+e.getMessage());
            logger.error("saveProductImages failed :"+e.getMessage());
        }

    }
    public void checkNameProduct(String productName)
    {
        try {
            List<Product> listProduct = productManager.getListProduct();
            for(int i = 0 ; i < listProduct.size() ; i++)
            {
                if(listProduct.get(i).getProductName() == productName)
                {
                    throw new ProductAlreadyException();
                }
            }

        } catch (ProductNotFoundException e) {
            logger.error("saveProduct failed , getListProduct failed : "+e.getMessage());
        } catch (ProductAlreadyException e) {
            logger.error("saveProduct failed , Product is exist in database...");
        }

    }
    public void checkNameProductDetail(String productDetailName)
    {
        try {
            List<ProductDetail> listProductDetail = productDetailManager.getListProductDetail();
            for(int i = 0 ; i < listProductDetail.size() ; i++)
            {
                if(listProductDetail.get(i).getProductDetailName() == productDetailName)
                {
                    throw new ProductDetailAlreadyException();
                }
            }
        } catch (ProductDetailNotFoundException e) {
            logger.error("saveProductDetail failed , getListProductDetail failed :"+e.getMessage());
        } catch (ProductDetailAlreadyException e) {
            logger.error("saveProductDetail failed , nameProductDetail exist ...");
        }
    }


}
