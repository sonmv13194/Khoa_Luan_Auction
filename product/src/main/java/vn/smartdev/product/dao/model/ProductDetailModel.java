package vn.smartdev.product.dao.model;

import javax.persistence.Column;

/**
 * Created by Nhat on 07/12/2016.
 */
public class ProductDetailModel {
    private String id;
    private String description;

    private String productDetailName;

    private float productDetailPrice;

    private int productDetailQuantity;

    private int productDetailStatus;

    private String supplyer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductDetailName() {
        return productDetailName;
    }

    public void setProductDetailName(String productDetailCode) {
        this.productDetailName = productDetailName;
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

    public int getProductDetailStatus() {
        return productDetailStatus;
    }

    public void setProductDetailStatus(int productDetailStatus) {
        this.productDetailStatus = productDetailStatus;
    }

    public String getSupplyer() {
        return supplyer;
    }

    public void setSupplyer(String supplyer) {
        this.supplyer = supplyer;
    }
}
