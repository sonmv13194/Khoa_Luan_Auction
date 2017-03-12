package vn.smartdev.comment.dao.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.smartdev.comment.dao.entity.CommentEntity;
import vn.smartdev.comment.dao.repository.CommentRepository;
@Component
public class CommentManagerImp implements CommentManager{
	@Autowired
	CommentRepository commentRepository;

	@Override
	public CommentEntity create(CommentEntity commentEntity) {
		// TODO Auto-generated method stub
		return commentRepository.save(commentEntity);
	}

	@Override
	public List<CommentEntity> groupCommentModels() {
		// TODO Auto-generated method stub
		return commentRepository.findAll();
	}


}
