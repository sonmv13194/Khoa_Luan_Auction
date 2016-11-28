package vn.smartdev.user.dao.entity;

import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role extends AbstractAuditableEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="last_updated")
	private Date lastUpdated;

	@Column(name="last_updated_by")
	private String lastUpdatedBy;

	@Column(name="role_name")
	private String roleName;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="role_user"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="user_id")
			}
		)
	private List<User> users;

	public Role() {
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

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}