package vn.smartdev.order.dao.entity;

import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the order_history database table.
 * 
 */
@Entity
@Table(name="order_history")
@NamedQuery(name="OrderHistory.findAll", query="SELECT o FROM OrderHistory o")
public class OrderHistory extends AbstractAuditableEntity<String> implements Serializable {
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

	@Column(name="status_name")
	private String statusName;

	//bi-directional many-to-one association to OrderDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private OrderDetail orderDetail;

	public OrderHistory() {
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

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public OrderDetail getOrderDetail() {
		return this.orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

}