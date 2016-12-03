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


	@Column(name="product_name")
	private String productName;

	@Column(name="description")
	private String description;



	public Product(String productName, String description) {
		this.productName = productName;
		this.description = description;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="category_id",insertable = false,updatable = false)
    private Category category;
//	@ManyToOne
//	@JoinColumn(name = "category_id")




	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL)
	private List<ProductDetail> productDetails;

	//contruster

	public Product(String productName, Category category, List<ProductDetail> productDetails) {
		this.productName = productName;
		this.productDetails = productDetails;
	}

	public Product() {
		setId(UUID.randomUUID().toString());
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