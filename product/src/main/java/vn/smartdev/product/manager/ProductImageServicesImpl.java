package vn.smartdev.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductModel;
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
    public boolean checkNameImage(ProductModel productModel) {
        String nameImage = productModel.getFile().getOriginalFilename();
        List<ProductImage> listProductImage = productImageRepository.findAll();
        try {
            for(int i = 0 ; i < listProductImage.size(); i++)
            {
                if(listProductImage.get(i).getUrl().equals(nameImage))
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return false;
    }

    @Override
    public boolean uploadFile(ProductModel productModel,String urlImage) {
            MultipartFile file = productModel.getFile();
            try {
                byte bytes[] = file.getBytes();
                //test resource localhost
                String name = file.getOriginalFilename();
                String demo = urlImage+name;
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

}
