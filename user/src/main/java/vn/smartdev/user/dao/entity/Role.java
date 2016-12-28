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
@Table(name = "role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role extends AbstractAuditableEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="role_name")
	private String roleName;

	private boolean deleted;

	public Role(String roleName) {
		this.roleName = roleName;
	}

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER, targetEntity = User.class)
	private List<User> users;

	public Role() {
		setId(UUID.randomUUID().toString());
	}

	public String getRoleName() {
		return this.roleName;
	}

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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