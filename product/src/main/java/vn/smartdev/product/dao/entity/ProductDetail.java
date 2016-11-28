package vn.smartdev.product.dao.entity;

import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the product_detail database table.
 * 
 */
@Entity
@Table(name="product_detail")
@NamedQuery(name="ProductDetail.findAll", query="SELECT p FROM ProductDetail p")
public class ProductDetail extends AbstractAuditableEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

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

	@Column(name="product_detail_code")
	private String productDetailCode;

	@Column(name="product_detail_price")
	private float productDetailPrice;

	@Column(name="product_detail_quantity")
	private int productDetailQuantity;

	@Column(name="product_detail_status")
	private int productDetailStatus;

	private String supplyer;

	/*//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="productDetail")
	private List<OrderDetail> orderDetails;*/

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_parent_id")
	private Product product;

	//bi-directional many-to-one association to ProductImage
	@OneToMany(mappedBy="productDetail")
	private List<ProductImage> productImages;

	public ProductDetail() {
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

	public String getProductDetailCode() {
		return this.productDetailCode;
	}

	public void setProductDetailCode(String productDetailCode) {
		this.productDetailCode = productDetailCode;
	}

	public float getProductDetailPrice() {
		return this.productDetailPrice;
	}

	public void setProductDetailPrice(float productDetailPrice) {
		this.productDetailPrice = productDetailPrice;
	}

	public int getProductDetailQuantity() {
		return this.productDetailQuantity;
	}

	public void setProductDetailQuantity(int productDetailQuantity) {
		this.productDetailQuantity = productDetailQuantity;
	}

	public int getProductDetailStatus() {
		return this.productDetailStatus;
	}

	public void setProductDetailStatus(int productDetailStatus) {
		this.productDetailStatus = productDetailStatus;
	}

	public String getSupplyer() {
		return this.supplyer;
	}

	public void setSupplyer(String supplyer) {
		this.supplyer = supplyer;
	}

	/*public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setProductDetail(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setProductDetail(null);

		return orderDetail;
	}*/

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductImage> getProductImages() {
		return this.productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public ProductImage addProductImage(ProductImage productImage) {
		getProductImages().add(productImage);
		productImage.setProductDetail(this);

		return productImage;
	}

	public ProductImage removeProductImage(ProductImage productImage) {
		getProductImages().remove(productImage);
		productImage.setProductDetail(null);

		return productImage;
	}

}