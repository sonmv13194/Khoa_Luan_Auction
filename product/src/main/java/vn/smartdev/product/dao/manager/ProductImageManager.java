package vn.smartdev.product.dao.manager;

import org.springframework.web.multipart.MultipartFile;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.exception.ProductImageAlreadyException;
import vn.smartdev.product.exception.ProductImageNotFoundException;
import vn.smartdev.product.exception.UploadFileFailedException;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Nhat on 28/12/2016.
 */
public interface ProductImageManager {
    List<ProductImage> getListProductImage() throws ProductImageNotFoundException;

    ProductImage getProductImage(String id) throws ProductImageNotFoundException;

    void saveProductImage(ProductImage productImage) throws ProductImageAlreadyException;

    void deleteProductImage(String id) throws ProductImageNotFoundException;

    void uploadFile(Product product,String urlImage,MultipartFile file) throws UploadFileFailedException;
}
