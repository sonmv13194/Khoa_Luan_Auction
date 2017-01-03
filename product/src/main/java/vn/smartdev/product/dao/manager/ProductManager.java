package vn.smartdev.product.dao.manager;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductModel;
import vn.smartdev.product.exception.ProductAlreadyException;
import vn.smartdev.product.exception.ProductNotFoundException;

import java.util.List;
/** * Created by Nhat on 28/12/2016. */
public interface ProductManager {    
  List<Product> getListProduct() throws ProductNotFoundException;
  Product getProduct(String id) throws ProductNotFoundException;
  void saveProduct(Product product) throws ProductAlreadyException;
  void deleteProduct(String id) throws ProductNotFoundException;
}
