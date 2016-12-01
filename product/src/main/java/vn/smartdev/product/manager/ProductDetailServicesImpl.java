package vn.smartdev.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.repository.ProductDetailRepository;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
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
}
