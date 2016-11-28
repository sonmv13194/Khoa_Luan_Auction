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

	@Column(name="status_name")
	private String statusName;

	//bi-directional many-to-one association to OrderDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private OrderDetail orderDetail;

	public OrderHistory() {
		setId(UUID.randomUUID().toString());
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