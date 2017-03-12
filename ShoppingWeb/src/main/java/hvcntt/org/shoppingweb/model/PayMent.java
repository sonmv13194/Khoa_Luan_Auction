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
@Table(name="payment")
public class PayMent {
	@Id
	@GeneratedValue
	private int idpayment;
	@Column(name="totalprice")
	private double totalprice;
	@Column(name="quantity")
	private int quantity;
	@Column(name="createdate")
	private Date createdate;
	@Column(name="lastupdate")
	private Date lastupdate;
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;
	@ManyToOne
	@JoinColumn(name="idproduct")
	private Product product;
	public PayMent() {
		// TODO Auto-generated constructor stub
	}
	public PayMent(double totalprice, int quantity, Date createdate, Date lastupdate, User user, Product product) {
		super();
		this.totalprice = totalprice;
		this.quantity = quantity;
		this.createdate = createdate;
		this.lastupdate = lastupdate;
		this.user = user;
		this.product = product;
	}
	public int getIdpayment() {
		return idpayment;
	}
	public void setIdpayment(int idpayment) {
		this.idpayment = idpayment;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
