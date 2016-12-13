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

	private String note;

	private int quantity;

	//bi-directional many-to-one association to Invoice
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="invoice_id")
	private Invoice invoice;

	//bi-directional many-to-one association to ProductDetail
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="product_detail_id")
	private ProductDetail productDetail;

	public InvoiceDetail() {
		setId(UUID.randomUUID().toString());
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

}