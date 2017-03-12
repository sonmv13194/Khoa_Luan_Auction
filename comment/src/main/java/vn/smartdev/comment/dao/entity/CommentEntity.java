package vn.smartdev.comment.dao.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.user.dao.entity.User;

@Entity
@Table(name="comment")
@NamedQuery(name="Comment.findAll",query="SELECT c FROM Comment c")
public class CommentEntity extends AbstractAuditableEntity<String> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@ManyToOne(targetEntity=Product.class)
	@JoinColumn(name="productID", referencedColumnName="id")
	Product product;
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="userId",referencedColumnName="id")
	User user;
	public CommentEntity() {
		setId(UUID.randomUUID().toString());
	}
	
	public CommentEntity(String title, String content, Product product, User user) {
		super();
		this.title = title;
		this.content = content;
		this.product = product;
		this.user = user;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
