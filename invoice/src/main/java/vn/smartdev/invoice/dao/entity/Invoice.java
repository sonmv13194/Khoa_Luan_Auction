package vn.smartdev.invoice.dao.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;
import vn.smartdev.invoice.validation.Phone;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the invoice database table.
 *
 */
@Entity
@Table(name="invoice")
public class Invoice extends AbstractAuditableEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "username")
	private String username;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "city")
	private String city;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "invoice_date")
	private Date invoiceDate;

	//bi-directional many-to-one association to InvoiceDetail
	@OneToMany(mappedBy="invoice")
	private List<InvoiceDetail> invoiceDetails;

	public Invoice(String username) {
		this.username = username;
	}

	public Invoice() {
		setId(UUID.randomUUID().toString());
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLasttName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<InvoiceDetail> getInvoiceDetails() {
		return this.invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public InvoiceDetail addInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().add(invoiceDetail);
		invoiceDetail.setInvoice(this);

		return invoiceDetail;
	}

	public InvoiceDetail removeInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().remove(invoiceDetail);
		invoiceDetail.setInvoice(null);
		return invoiceDetail;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
}