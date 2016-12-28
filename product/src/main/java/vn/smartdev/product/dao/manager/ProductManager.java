package vn.smartdev.product.dao.manager;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.model.ProductModel;
import java.util.List;
/** * Created by Nhat on 28/12/2016. */
public interface ProductManager {    
  List<Product> getListProduct();
  Product getProduct(String id);
  void saveProduct(Product product);
  void deleteProduct(String id);
  boolean createProduct(ProductModel productModel);
}
