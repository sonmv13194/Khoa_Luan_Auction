package vn.smartdev.product.dao.manager;

import org.springframework.web.multipart.MultipartFile;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductModel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Nhat on 28/12/2016.
 */
public interface ProductImageManager {
    public List<ProductImage> getListProductImage();

    public ProductImage getProductImage(String id);

    public void saveProductImage(ProductImage productImage);

    public void deleteProductImage(String id);

    public boolean uploadFile(ProductModel productModel);
}
