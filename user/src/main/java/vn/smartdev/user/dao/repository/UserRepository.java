package vn.smartdev.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.smartdev.user.dao.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
    int countByUsernameOrEmailOrPhoneAndIdNotIn(String username, String email, String phone, String id);
    List<User> findAllNotDeleted();
    User findByIdAndDeletedIsFalse(String userId);
}
