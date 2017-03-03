package hvcntt.org.shoppingweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue
	private int idcomment;
	@Column(name="content")
	private String content;
	@Column(name="title")
	private String title;
	@Column(name="createdate")
	private Date createdate;
	@Column(name="lastupdate")
	private Date lastupdate;
	
	@ManyToOne
	@JoinColumn(name="idproduct")
	Product product;
	@ManyToOne
	@JoinColumn(name="iduser")
	User user;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(String content, String title, Date createdate, Date lastupdate, Product product, User user) {
		super();
		this.content = content;
		this.title = title;
		this.createdate = createdate;
		this.lastupdate = lastupdate;
		this.product = product;
		this.user = user;
	}
	public int getIdcomment() {
		return idcomment;
	}
	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
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
	@Override
	public String toString() {
		return "Comment [idcomment=" + idcomment + ", content=" + content + ", title=" + title + ", createdate="
				+ createdate + ", lastupdate=" + lastupdate + ", product=" + product + ", user=" + user + "]";
	}
	
}
