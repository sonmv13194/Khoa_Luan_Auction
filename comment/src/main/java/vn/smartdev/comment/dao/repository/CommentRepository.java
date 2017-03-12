package vn.smartdev.comment.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.smartdev.comment.dao.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, String> {

}
