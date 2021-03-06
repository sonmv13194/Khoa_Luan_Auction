package vn.smartdev.product.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.dao.repository.ProductImageRepository;
import vn.smartdev.product.exception.ProductImageAlreadyException;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Nhat on 26/12/2016.
 */
@Component
public class ProductImageManagerImpl implements ProductImageManager{
    @Autowired
    private ProductImageRepository productImageRepository;

    public List<ProductImage> getListProductImage() {
        return productImageRepository.findAll();
    }

    public ProductImage getProductImage(String id) {
        return productImageRepository.findOne(id);
    }

    public void saveProductImage(ProductImage productImage){
        productImageRepository.save(productImage);
    }

    public void deleteProductImage(String id) {
        productImageRepository.delete(id);
    }

    public void uploadFile(Product product,String urlImage,MultipartFile file) {
        try {
            byte bytes[] = file.getBytes();
            //test resource localhost
            String name = file.getOriginalFilename();
            String demo = urlImage+product.getProductName()+"_"+name;
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(demo)));
            stream.write(bytes);
            stream.flush();
            stream.close();
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
