package vn.smartdev.invoice.dao.model;

import vn.smartdev.product.dao.entity.ProductDetail;

import java.io.Serializable;

public class CartModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDetail productDetail;
	private int quantity;
	private int discount;

	public CartModel() {
		super();
	}
	
	public CartModel(ProductDetail productDetail, int quantity, int discount) {
		super();
		this.productDetail = productDetail;
		this.discount = discount;
		this.quantity = quantity;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
