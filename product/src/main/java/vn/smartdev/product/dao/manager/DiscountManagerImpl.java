package vn.smartdev.product.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smartdev.product.dao.entity.Discount;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.repository.DiscountRepository;

import java.util.List;

/**
 * Created by Nhat on 28/12/2016.
 */
@Component
public class DiscountManagerImpl implements DiscountManager {
    @Autowired
    DiscountRepository discountRepository;

    @Override
    public Discount findByProduct(Product product) {
        return discountRepository.findByProduct(product);
    }

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public void delete(String discountID) {
        discountRepository.delete(discountID);
    }

    @Override
    public void save(Discount discount) {
        discountRepository.save(discount);
    }
}
