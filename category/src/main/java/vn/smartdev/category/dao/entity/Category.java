package vn.smartdev.category.dao.entity;

import vn.smartdev.core.jpa.auditing.AbstractAuditableEntity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.UUID;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name = "category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category extends AbstractAuditableEntity<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="category_name")
	private String categoryName;

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category() {
		setId(UUID.randomUUID().toString());
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName() + "-");
		sb.append("  id=" + getId());
		sb.append("  id=" + getCategoryName());
		sb.append("  lastUpdated=" + getLastUpdated());
		sb.append("  lastUpdateBy=" + getLastUpdatedBy());
		sb.append("  created=" + getCreated());
		sb.append("  createdBy=" + getCreateBy());
		return sb.toString();
	}

}