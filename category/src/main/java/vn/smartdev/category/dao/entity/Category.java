package vn.smartdev.category.dao.entity;

import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category extends AbstractAuditableEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="category_name")
	private String categoryName;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="last_update_by")
	private String lastUpdateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updated")
	private Date lastUpdated;

	private int nhat;

	/*//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category")
	private List<Product> products;*/

	public Category() {
		setId(UUID.randomUUID().toString());
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public String getLastUpdateBy() {
		return this.lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getNhat() {
		return this.nhat;
	}

	public void setNhat(int nhat) {
		this.nhat = nhat;
	}

	/*public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}*/

}