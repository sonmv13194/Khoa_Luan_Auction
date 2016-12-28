package vn.smartdev.product.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.manager.ProductImageManager;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.dao.repository.ProductImageRepository;
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
    @Autowired
    private ProductImageManager productImageManager;

    @Override
    public List<ProductImage> getListProductImage() {
        return productImageManager.getListProductImage();
    }

    @Override
    public ProductImage getProductImage(String id) {
        return productImageManager.getProductImage(id);
    }

    @Override
    public void saveProductImage(ProductImage productImage) {
        productImageManager.saveProductImage(productImage);
    }

    @Override
    public void deleteProductImage(String id) {
        productImageManager.deleteProductImage(id);
    }

    @Override
    public boolean uploadFile(ProductModel productModel) {
        Product product = new Product();
        product.setProductName(productModel.getProductName());
        String urlImages = productModel.getUrlImage();
        MultipartFile file = productModel.getFile();
            productImageManager.uploadFile(product,urlImages,file);
        return false;
    }

}
