package vn.smartdev.product.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.repository.CategoryRepository;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductDetailModel;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.dao.repository.ProductDetailRepository;
import vn.smartdev.product.dao.repository.ProductImageRepository;
import vn.smartdev.product.dao.repository.ProductRepository;
import vn.smartdev.product.exception.ProductDetailAlreadyException;

import java.util.List;

/**
 * Created by Nhat on 26/12/2016.
 */
@Component
public class ProductDetailManagerImpl implements ProductDetailManager{
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDetail> getListProductDetail() {
        return productDetailRepository.findAll();
    }

    @Override
    public ProductDetail getProductDetail(String id) {
        return productDetailRepository.findOne(id);
    }

    @Override
    public void deleteProductDetail(String id) {
        productDetailRepository.delete(id);
    }

    @Override
    public void saveProductDetail(ProductDetail productDetail) throws ProductDetailAlreadyException {
        productDetailRepository.save(productDetail);
    }



    @Override
    public List<ProductDetail> findTop6ByOrderByCreateByDesc() {
        return productDetailRepository.findTop6ByOrderByCreateByDesc();
    }

    @Override
    public List<ProductDetail> findTop6ByOrderByProductDetailPriceDesc() {
        return productDetailRepository.findTop6ByOrderByProductDetailPriceDesc();
    }

    @Override
    public List<ProductDetail> findTop3ByOrderByProductDetailPriceAsc() {
        return productDetailRepository.findTop3ByOrderByProductDetailPriceAsc();
    }

    @Override
    public List<ProductDetail> findTop8ByOrderByCreateByAsc() {
        return productDetailRepository.findTop8ByOrderByCreateByAsc();
    }

    @Override
    public List<ProductDetail> findByOrderByProductDetailPriceAsc() {
        return productDetailRepository.findByOrderByProductDetailPriceAsc();
    }

    @Override
    public List<ProductDetail> findByOrderByProductDetailPriceDesc() {
        return productDetailRepository.findByOrderByProductDetailPriceDesc();
    }

    @Override
    public List<ProductDetail> getListProductDetailByProduct(String productId) {
        Product product = productRepository.findOne(productId);
        List<ProductDetail> listProductDetail = product.getProductDetails();
        return listProductDetail;
    }
}
