package vn.smartdev.product.manager;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductImageModel;

import java.util.List;

/**
 * Created by Nhat on 03/12/2016.
 */
public interface ProductImageServices {
    public List<ProductImage> getListProductImage();
    public ProductImage getProductImage(String id);
    public void savePorductImage(ProductImage productImage);
    public void deleteProductImage(String id);
    public boolean checkNameImage(List<ProductImage> listProductImage, String nameImage);
    public boolean uploadFile(CommonsMultipartFile file, String urlImage);
    public ProductImage createProductImage(ProductImageModel productImageModel, ProductDetail productDetail);
}
