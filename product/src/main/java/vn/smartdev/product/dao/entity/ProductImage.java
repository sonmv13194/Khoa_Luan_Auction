package vn.smartdev.product.dao.entity;

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

	@Temporal(TemporalType.DATE)
	private Date created;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updated")
	private Date lastUpdated;

	@Column(name="last_updated_by")
	private String lastUpdatedBy;

	@Lob
	private String url;

	//bi-directional many-to-one association to ProductDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_detail_id")
	private ProductDetail productDetail;

	public ProductImage() {
		setId(UUID.randomUUID().toString());
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
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