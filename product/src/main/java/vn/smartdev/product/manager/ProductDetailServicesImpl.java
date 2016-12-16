package vn.smartdev.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
@Service
public class ProductDetailServicesImpl implements ProductDetailServices{
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
    public boolean createProductDetail(ProductModel productModel) {
        try
        {
            Category category = categoryRepository.findOne(productModel.getCategoryId());
            //Product
            Product product = productRepository.getOne(productModel.getProductId());

            //productDetail
            ProductDetail productDetail = new ProductDetail();
            productDetail.setProductDetailCode("1");
            productDetail.setProductDetailStatus(productModel.getProductStatus());
            productDetail.setProductDetailPrice(productModel.getPrice());
            productDetail.setProductDetailQuantity(productModel.getQuantity());
            productDetail.setDescription(productDetail.getDescription());
            productDetail.setSupplyer(productDetail.getSupplyer());
            productDetail.setProduct(product);
            productDetailRepository.save(productDetail);

            //productImage
            ProductImage productImage = new ProductImage();
            productImage.setUrl(productModel.getFile().getOriginalFilename());
            productImage.setProductDetail(productDetail);

            productImageRepository.save(productImage);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean updateProductDetail(ProductDetailModel productDetailModel) {
        ProductDetail productDetail = productDetailRepository.findOne(productDetailModel.getId());
        productDetail.setDescription(productDetailModel.getDescription());
        productDetail.setProductDetailPrice(productDetailModel.getProductDetailPrice());
        productDetail.setProductDetailQuantity(productDetailModel.getProductDetailQuantity());
        productDetail.setSupplyer(productDetailModel.getSupplyer());

        productDetailRepository.save(productDetail);
        return true;
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
    public List<ProductDetail> getListProductDetailByCategory(String categoryId) {
        List<ProductDetail> listProductDetail = productDetailRepository.findAll();
        List<ProductDetail> listProductDetailnew = new ArrayList<ProductDetail>();
        for(int i = 0 ; i < listProductDetail.size() ; i++)
        {
            if(listProductDetail.get(i).getProduct().getCategory().getId().equals(categoryId))
            {
                listProductDetailnew.add(listProductDetail.get(i));
            }
        }
        return listProductDetailnew;
    }
}
