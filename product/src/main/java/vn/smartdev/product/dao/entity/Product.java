package vn.smartdev.product.dao.entity;

import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product extends AbstractAuditableEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Column(name="created_by")
	private String createdBy;

	@Lob
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updated")
	private Date lastUpdated;

	@Column(name="last_updated_by")
	private String lastUpdatedBy;

	@Column(name="product_name")
	private String productName;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;

	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="product")
	private List<ProductDetail> productDetails;

	public Product() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetail addProductDetail(ProductDetail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setProduct(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setProduct(null);

		return productDetail;
	}

}