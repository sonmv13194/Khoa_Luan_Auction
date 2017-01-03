package vn.smartdev.product.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.manager.ProductImageManager;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.dao.repository.ProductImageRepository;
import vn.smartdev.product.exception.ProductImageAlreadyException;
import vn.smartdev.product.exception.ProductImageNotFoundException;
import vn.smartdev.product.exception.UploadFileFailedException;
import vn.smartdev.product.services.ProductImageServices;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Nhat on 03/12/2016.
 */
@Service
public class ProductImageServicesImpl implements ProductImageServices {
    private static final Logger logger = LoggerFactory.getLogger(ProductImageServicesImpl.class);
    @Autowired
    private ProductImageManager productImageManager;

    @Override
    public List<ProductImage> getListProductImage() {
        List<ProductImage> listProductImages = null;
        try
        {
            listProductImages = productImageManager.getListProductImage();
        }
        catch (ProductImageNotFoundException e)
        {
            logger.error("getListProductImages not found : "+e.getMessage());
        }
        return listProductImages;
    }

    @Override
    public ProductImage getProductImage(String id) {
        ProductImage productImage = null;
        try
        {
            productImage = productImageManager.getProductImage(id);
        }
        catch (ProductImageNotFoundException e)
        {
            logger.error("getProductImage not found : "+e.getMessage());
        }
        return productImage;
    }

    @Override
    public void saveProductImage(ProductImage productImage) {
        try
        {
            productImageManager.saveProductImage(productImage);
        }
        catch (ProductImageAlreadyException e)
        {
            logger.error("saveProductImage failed :"+e.getMessage());
        }
    }

    @Override
    public void deleteProductImage(String id) {
        try
        {
            productImageManager.deleteProductImage(id);
        } catch (ProductImageNotFoundException e) {
            logger.error("deleteProductImage failed :"+e.getMessage());
        }
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void uploadFile(ProductModel productModel) {

        Product product = new Product();
        product.setProductName(productModel.getProductName());
        String urlImages = productModel.getUrlImage();
        MultipartFile file = productModel.getFile();
        try {
            productImageManager.uploadFile(product,urlImages,file);
        } catch (UploadFileFailedException e) {
            logger.error("Uploadfile failed :"+e.getMessage());
        }
    }

}
