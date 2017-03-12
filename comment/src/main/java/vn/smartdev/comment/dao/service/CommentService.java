package vn.smartdev.comment.dao.service;

import java.util.List;

import vn.smartdev.comment.dao.entity.CommentEntity;

public interface CommentService {
	CommentEntity create(CommentEntity commentEntity);
	List<CommentEntity> getAll();
}
