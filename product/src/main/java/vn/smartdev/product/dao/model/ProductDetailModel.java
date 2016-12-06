package vn.smartdev.product.dao.model;

/**
 * Created by Nhat on 05/12/2016.
 */
public class ProductDetailModel {
    private String description;
    private int productDetailStatus;
    private String producDetailCode;
    private float productDetailPrice;
    private int productDetailQuantity;
    private String supplyer;

    public ProductDetailModel(String description, int productDetailStatus, float productDetailPrice, int productDetailQuantity, String supplyer) {
        this.description = description;
        this.productDetailStatus = productDetailStatus;
        this.producDetailCode = producDetailCode;
        this.productDetailPrice = productDetailPrice;
        this.productDetailQuantity = productDetailQuantity;
        this.supplyer = supplyer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductDetailStatus() {
        return productDetailStatus;
    }

    public void setProductDetailStatus(int productDetailStatus) {
        this.productDetailStatus = productDetailStatus;
    }

    public String getProducDetailCode() {
        return producDetailCode;
    }

    public void setProducDetailCode(String producDetailCode) {
        this.producDetailCode = producDetailCode;
    }

    public float getProductDetailPrice() {
        return productDetailPrice;
    }

    public void setProductDetailPrice(float productDetailPrice) {
        this.productDetailPrice = productDetailPrice;
    }

    public int getProductDetailQuantity() {
        return productDetailQuantity;
    }

    public void setProductDetailQuantity(int productDetailQuantity) {
        this.productDetailQuantity = productDetailQuantity;
    }

    public String getSupplyer() {
        return supplyer;
    }

    public void setSupplyer(String supplyer) {
        this.supplyer = supplyer;
    }
}
