package vn.smartdev.product.dao.manager;

import vn.smartdev.product.dao.entity.Discount;
import vn.smartdev.product.dao.entity.Product;

import java.util.List;

/**
 * Created by Nhat on 28/12/2016.
 */
public interface DiscountManager {
    Discount findByProduct(Product product);
    List<Discount> findAll();
    void delete(String discountID);
    void save(Discount discount);
}
