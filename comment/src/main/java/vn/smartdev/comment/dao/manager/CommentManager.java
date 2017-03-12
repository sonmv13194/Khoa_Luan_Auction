package vn.smartdev.comment.dao.manager;

import java.util.List;

import vn.smartdev.comment.dao.entity.CommentEntity;


public interface CommentManager {
	CommentEntity create(CommentEntity commentEntity);
	List<CommentEntity> groupCommentModels();
}
