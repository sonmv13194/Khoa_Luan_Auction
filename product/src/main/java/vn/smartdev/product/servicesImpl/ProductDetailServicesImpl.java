package vn.smartdev.product.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import vn.smartdev.product.services.ProductDetailServices;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
@Service
public class ProductDetailServicesImpl implements ProductDetailServices {
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
        return productDetailManager.getListProductDetail();
    }

    @Override
    public ProductDetail getProductDetail(String id) {
        return productDetailManager.getProductDetail(id);
    }

    @Override
    public void deleteProductDetail(String id) {
        productDetailManager.deleteProductDetail(id);
    }

    @Override
    public void saveProductDetail(ProductDetail productDetail) {
        productDetailManager.saveProductDetail(productDetail);
    }

    @Override
    public boolean createProductDetail(ProductModel productModel) {
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
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean updateProductDetail(ProductDetailModel productDetailModel) {
        ProductDetail productDetail = productDetailManager.getProductDetail(productDetailModel.getId());
        productDetail.setDescription(productDetailModel.getDescription());
        productDetail.setProductDetailPrice(productDetailModel.getProductDetailPrice());
        productDetail.setProductDetailQuantity(productDetailModel.getProductDetailQuantity());
        productDetail.setSupplyer(productDetailModel.getSupplyer());

        productDetailManager.saveProductDetail(productDetail);
        return true;
    }

    @Override
    public List<ProductDetail> findTop6ByOrderByCreateByDesc() {
        return productDetailManager.findTop6ByOrderByCreateByDesc();
    }

    @Override
    public List<ProductDetail> findTop6ByOrderByProductDetailPriceDesc() {
        return productDetailManager.findTop6ByOrderByProductDetailPriceDesc();
    }

    @Override
    public List<ProductDetail> findTop3ByOrderByProductDetailPriceAsc() {
        return productDetailManager.findTop3ByOrderByProductDetailPriceAsc();
    }

    @Override
    public List<ProductDetail> findTop8ByOrderByCreateByAsc() {
        return productDetailManager.findTop8ByOrderByCreateByAsc();
    }

    @Override
    public List<ProductDetail> findByOrderByProductDetailPriceAsc() {
        return productDetailManager.findByOrderByProductDetailPriceAsc();
    }

    @Override
    public List<ProductDetail> findByOrderByProductDetailPriceDesc() {
        return productDetailManager.findByOrderByProductDetailPriceDesc();
    }

    @Override
    public List<ProductDetail> getListProductDetailByProduct(String productId) {
        Product product = productManager.getProduct(productId);
        List<ProductDetail> listProductDetail = product.getProductDetails();
        return listProductDetail;
    }

}
