package vn.smartdev.comment.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.smartdev.comment.dao.entity.CommentEntity;
import vn.smartdev.comment.dao.manager.CommentManager;
@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	CommentManager commentManager;
	@Override
	public CommentEntity create(CommentEntity commentEntity) {
		// TODO Auto-generated method stub
		return commentManager.create(commentEntity);
	}

	@Override
	public List<CommentEntity> getAll() {
		// TODO Auto-generated method stub
		return commentManager.groupCommentModels();
	}

}
