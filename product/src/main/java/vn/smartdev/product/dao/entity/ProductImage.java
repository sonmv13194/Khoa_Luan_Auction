package vn.smartdev.product.dao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the product_images database table.
 * 
 */
@Entity
@Table(name="product_images")
@NamedQuery(name="ProductImage.findAll", query="SELECT p FROM ProductImage p")
public class ProductImage extends AbstractAuditableEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String url;

	//bi-directional many-to-one association to ProductDetail
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_detail_id")
	@JsonManagedReference
	private ProductDetail productDetail;

	public ProductImage(String url) {
		this.url = url;
	}

	public ProductImage() {
		setId(UUID.randomUUID().toString());
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ProductDetail getProductDetail() {
		return this.productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

}