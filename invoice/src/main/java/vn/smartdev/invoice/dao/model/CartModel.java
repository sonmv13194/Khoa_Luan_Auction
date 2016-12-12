package vn.smartdev.invoice.dao.model;

import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;

import java.io.Serializable;

public class CartModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDetail productDetail;
	private int quantity;
	public CartModel() {
		super();
	}
	
	public CartModel(ProductDetail productDetail, int quantity) {
		super();
		this.productDetail = productDetail;
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
	
}
