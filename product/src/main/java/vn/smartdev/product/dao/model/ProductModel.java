package vn.smartdev.product.dao.model;

/**
 * Created by Nhat on 05/12/2016.
 */
public class ProductModel {
    private String productName;
    private String description;

    public ProductModel(String productName, String description) {
        this.productName = productName;
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
