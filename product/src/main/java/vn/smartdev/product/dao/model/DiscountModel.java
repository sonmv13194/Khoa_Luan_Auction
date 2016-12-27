package vn.smartdev.product.dao.model;


import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;
import vn.smartdev.product.dao.entity.Product;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the discount database table.
 */
public class DiscountModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date startDate;

    private Date endDate;

    private int discount;

    //	bi-directional many-to-one association to Category
    private String productId;

    public DiscountModel() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}