package vn.smartdev.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductImageModel;
import vn.smartdev.product.dao.repository.ProductImageRepository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Nhat on 03/12/2016.
 */
@Service
public class ProductImageServicesImpl implements ProductImageServices{
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public List<ProductImage> getListProductImage() {
        return productImageRepository.findAll();
    }

    @Override
    public ProductImage getProductImage(String id) {
        return productImageRepository.findOne(id);
    }

    @Override
    public void savePorductImage(ProductImage productImage) {
        productImageRepository.save(productImage);
    }

    @Override
    public void deleteProductImage(String id) {
        productImageRepository.delete(id);
    }

    @Override
    public boolean checkNameImage(List<ProductImage> listProductImage,String nameImage) {
        try {
            for(int i = 0 ; i < listProductImage.size(); i++)
            {
                if(listProductImage.get(i).getUrl().equals(nameImage))
                {
                    return true;
                }
                break;
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return false;
    }

    @Override
    public boolean uploadFile(CommonsMultipartFile file,String urlImage) {

            try {
                byte bytes[] = file.getBytes();
                //test resource localhost
                String name = file.getOriginalFilename();
                String demo = "C:\\Users\\Nhat\\IdeaProjects\\java-training-shop\\web-client\\src\\main\\webapp\\resource\\images\\"+name;
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(demo)));
                stream.write(bytes);
                stream.flush();
                stream.close();
                return true;
            }
            catch (FileNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return false;
    }

    @Override
    public ProductImage createProductImage(ProductImageModel productImageModel, ProductDetail productDetail) {
        ProductImage productImage = new ProductImage();
        productImage.setUrl(productImageModel.getUrl());
        productImage.setProductDetail(productDetail);
        return productImage;
    }
}
