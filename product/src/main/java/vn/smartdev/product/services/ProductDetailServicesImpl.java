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
import vn.smartdev.category.dao.repository.CategoryRepository;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.manager.*;
import vn.smartdev.product.dao.model.ProductDetailModel;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.dao.repository.ProductDetailRepository;
import vn.smartdev.product.dao.repository.ProductImageRepository;
import vn.smartdev.product.dao.repository.ProductRepository;
import vn.smartdev.product.exception.ProductDetailAlreadyException;
import vn.smartdev.product.exception.ProductDetailNotFoundException;
import vn.smartdev.product.exception.ProductImageAlreadyException;
import vn.smartdev.product.exception.ProductNotFoundException;
import vn.smartdev.product.services.ProductDetailServices;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
@Service
public class ProductDetailServicesImpl implements ProductDetailServices {
    private static final Logger logger = LoggerFactory.getLogger(ProductDetailServicesImpl.class);

    @Autowired
    private ProductManager productManager;
    @Autowired
    private ProductDetailManager productDetailManager;
    @Autowired
    private ProductImageManager productImageManager;
    @Autowired
    private CategoryManager categoryManager;


    private ProductDetailManagerImpl productDetailManagerImpl = new ProductDetailManagerImpl();
    private ProductImageManagerImpl productImageManagerImpl = new ProductImageManagerImpl();

    @Override
    public List<ProductDetail> getListProductDetail() {
        List<ProductDetail> listProductDetail = null;
        try {
           listProductDetail = productDetailManager.getListProductDetail();
        }
        catch (ProductDetailNotFoundException e)
        {
            logger.error("getListProductDetail not found :"+e.getMessage());
        }
        return listProductDetail;
    }

    @Override
    public ProductDetail getProductDetail(String id) {
        ProductDetail productDetail  = null;
        try {
            productDetail = productDetailManager.getProductDetail(id);
        } catch (ProductDetailNotFoundException e) {
            logger.error("getProductDetail not found : "+e.getMessage());
        }
        return productDetail;
    }

    @Override
    public void deleteProductDetail(String id) {
        try {
            productDetailManager.deleteProductDetail(id);
        } catch (ProductDetailNotFoundException e) {
            logger.error("deleteProductDetail failed :"+e.getMessage());
        }
    }

    @Override
    public void saveProductDetail(ProductDetail productDetail) {
        try {
            checkNameProductDetail(productDetail.getProductDetailName());
            productDetailManager.saveProductDetail(productDetail);
        } catch (ProductDetailAlreadyException e) {
            logger.error("saveProductDetail failed :"+e.getMessage());
        }
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void createProductDetail(ProductModel productModel) {
        try
        {
            Category category = categoryManager.getCategory(productModel.getCategoryId());
            //Product
            Product product = productManager.getProduct(productModel.getProductId());

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
            productImage.setUrl(productModel.getProductName() + "_" + productModel.getFile().getOriginalFilename());
            productImage.setProductDetail(productDetail);

            productImageManager.saveProductImage(productImage);
        }
        catch (ProductNotFoundException | ProductDetailAlreadyException | ProductImageAlreadyException e)
        {
            //TODO
            logger.error("getProduct not found : "+e.getMessage());
            logger.error("saveProductDetail failed : "+e.getMessage());
            logger.error("saveProductImage failed : "+e.getMessage());
        }

    }

    @Override
    public void updateProductDetail(ProductDetailModel productDetailModel) {
        try {
            ProductDetail productDetail = productDetailManager.getProductDetail(productDetailModel.getId());
            productDetail.setDescription(productDetailModel.getDescription());
            productDetail.setProductDetailPrice(productDetailModel.getProductDetailPrice());
            productDetail.setProductDetailQuantity(productDetailModel.getProductDetailQuantity());
            productDetail.setSupplyer(productDetailModel.getSupplyer());
            productDetailManager.saveProductDetail(productDetail);
        }  catch (ProductDetailNotFoundException e) {
            logger.error("getProductDetail not found :"+e.getMessage());
        }
        catch (ProductDetailAlreadyException e) {
            logger.error("getProductDetail failed :"+e.getMessage());
        }

    }

    @Override
    public List<ProductDetail> findTop6ByOrderByCreateByDesc() {
        List<ProductDetail> listProductDetail = null;
        try
        {
            listProductDetail = productDetailManager.findTop6ByOrderByCreateByDesc();
        }
        catch (ProductDetailNotFoundException e)
        {
            logger.error("findTop6ByOrderByCreateByDesc not found :"+e.getMessage());
        }
        return listProductDetail;
    }

    @Override
    public List<ProductDetail> findTop6ByOrderByProductDetailPriceDesc() {
        List<ProductDetail> listProductDetail = null;
        try
        {
            listProductDetail = productDetailManager.findTop6ByOrderByProductDetailPriceDesc();
        }
        catch (ProductDetailNotFoundException e)
        {
            logger.error("findTop6ByOrderByProductDetailPriceDesc not found :"+e.getMessage());
        }
        return listProductDetail;
    }

    @Override
    public List<ProductDetail> findTop3ByOrderByProductDetailPriceAsc() {
        List<ProductDetail> listProductDetail = null;
        try
        {
            listProductDetail = productDetailManager.findTop3ByOrderByProductDetailPriceAsc();
        }
        catch (ProductDetailNotFoundException e)
        {
            logger.error("findTop3ByorderByProductDetailPriceAsc not found :"+e.getMessage());
        }
        return listProductDetail;
    }

    @Override
    public List<ProductDetail> findTop8ByOrderByCreateByAsc() {
        List<ProductDetail> listProductDetail = null;
        try
        {
            listProductDetail = productDetailManager.findTop8ByOrderByCreateByAsc();
        }
        catch (ProductDetailNotFoundException e)
        {
            logger.error("findTop8ByOrderByCreateByAsc not found :"+e.getMessage());
        }
        return listProductDetail;
    }

    @Override
    public List<ProductDetail> findByOrderByProductDetailPriceAsc() {
        List<ProductDetail> listProductDetail = null;
        try
        {
            listProductDetail = productDetailManager.findByOrderByProductDetailPriceAsc();
        }
        catch (ProductDetailNotFoundException e)
        {
            logger.error("findByOrderByProductDetailPriceAsc :"+e.getMessage());
        }
        return listProductDetail;
    }

    @Override
    public List<ProductDetail> findByOrderByProductDetailPriceDesc() {
        List<ProductDetail> listProductDetail = null;
        try
        {
            listProductDetail = productDetailManager.findByOrderByProductDetailPriceDesc();
        }
        catch (ProductDetailNotFoundException e)
        {
            logger.error("findByOrderByProductDetailPriceDesc :"+e.getMessage());
        }
        return listProductDetail;
    }

    @Override
    public List<ProductDetail> getListProductDetailByProduct(String productId){
        Product product = null;
        List<ProductDetail> listProductDetail = null;
        try {
            product = productManager.getProduct(productId);
            listProductDetail = product.getProductDetails();
            return listProductDetail;
        } catch (ProductNotFoundException e) {
            logger.error("getProduct not found :"+e.getMessage());
        }
        return listProductDetail;
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
