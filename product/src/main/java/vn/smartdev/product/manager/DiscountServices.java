package vn.smartdev.product.manager;import org.springframework.stereotype.Service;import vn.smartdev.product.dao.entity.Discount;import vn.smartdev.product.dao.entity.Product;import java.util.List;/** * Created by Nguyen on 16/12/2016. */public interface DiscountServices {    public Discount findByProduct(Product product);    public List<Discount> listAll();    void deleteDiscount(String discountID);    void save(Discount discount);}