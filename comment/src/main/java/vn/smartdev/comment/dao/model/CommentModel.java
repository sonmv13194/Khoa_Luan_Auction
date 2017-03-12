package vn.smartdev.comment.dao.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CommentModel {
	private String id;
	private String title;
	@NotBlank
	@Size(min = 2,max = 50)
	private String content;
	private String productId;
	private String userId;
	public CommentModel() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
