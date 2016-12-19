package vn.smartdev.invoice.dao.entity;

import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;
import vn.smartdev.product.dao.entity.ProductDetail;


import java.io.Serializable;
import javax.persistence.*;
import java.util.UUID;


/**
 * The persistent class for the invoice_detail database table.
 *
 */
@Entity
@Table(name="invoice_detail")
public class InvoiceDetail extends AbstractAuditableEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "discount")
	private int discount;

	private double amount;

	private int quantity;

	//bi-directional many-to-one association to Invoice
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="invoice_id")
	private Invoice invoice;

	//bi-directional many-to-one association to ProductDetail
	@ManyToOne(targetEntity = ProductDetail.class)
	@JoinColumn(name="product_detail_id",referencedColumnName = "id")
	private ProductDetail productDetail;

	public InvoiceDetail() {
		setId(UUID.randomUUID().toString());
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public ProductDetail getProductDetail() {
		return this.productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}