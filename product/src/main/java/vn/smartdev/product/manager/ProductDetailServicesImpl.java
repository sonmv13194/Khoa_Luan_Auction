package vn.smartdev.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.model.ProductDetailModel;
import vn.smartdev.product.dao.repository.ProductDetailRepository;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
@Service
public class ProductDetailServicesImpl implements ProductDetailServices{
    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public List<ProductDetail> getListProductDetail() {
        return productDetailRepository.findAll();
    }

    @Override
    public ProductDetail getProductDetail(String id) {
        return productDetailRepository.findOne(id);
    }

    @Override
    public double getTotal(String id) {
        ProductDetail productDetail = productDetailRepository.getOne(id);

        return productDetail.getProductDetailPrice() * productDetail.getProductDetailQuantity();
    }

    @Override
    public void deleteProductDetail(String id) {
        productDetailRepository.delete(id);
    }

    @Override
    public void saveProductDetail(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public ProductDetail createProductDetail(ProductDetailModel productDetailModel,Product product) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductDetailStatus(productDetailModel.getProductDetailStatus());
        productDetail.setProductDetailPrice(productDetailModel.getProductDetailPrice());
        productDetail.setProductDetailQuantity(productDetailModel.getProductDetailQuantity());
        productDetail.setSupplyer(productDetailModel.getSupplyer());
        productDetail.setProduct(product);
        return productDetail;
    }
}
