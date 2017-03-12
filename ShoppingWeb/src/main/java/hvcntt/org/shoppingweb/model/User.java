package hvcntt.org.shoppingweb.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User {
	private int id;
	private String username;
	private String password;
	private String passwordConfirm;
	private Set<Role> roles;
	private Set<Comment> comments;
	private Set<PayMent> payments;
	private AddresShipping addresship;
	private Information information;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	@ManyToMany
	@JoinTable(name="role_user",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	public Set<PayMent> getPayments() {
		return payments;
	}
	public void setPayments(Set<PayMent> payments) {
		this.payments = payments;
	}
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	public AddresShipping getAddresship() {
		return addresship;
	}
	public void setAddresship(AddresShipping addresship) {
		this.addresship = addresship;
	}
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	public Information getInformation() {
		return information;
	}
	public void setInformation(Information information) {
		this.information = information;
	}
	
	
	
}
