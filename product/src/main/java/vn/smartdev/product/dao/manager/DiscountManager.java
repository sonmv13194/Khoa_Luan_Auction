package vn.smartdev.product.dao.manager;

import vn.smartdev.product.dao.entity.Discount;
import vn.smartdev.product.dao.entity.Product;

import java.util.List;

/**
 * Created by Nhat on 28/12/2016.
 */
public interface DiscountManager {
    public Discount findByProduct(Product product);
    public List<Discount> listAll();
    void deleteDiscount(String discountID);
    void save(Discount discount);
}
