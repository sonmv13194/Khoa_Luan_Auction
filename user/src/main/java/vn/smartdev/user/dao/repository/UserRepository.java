package vn.smartdev.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.smartdev.user.dao.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);
    int countByUsernameOrEmailOrPhoneAndIdNotIn(String username, String email, String phone, String id);
    User findByIdAndDeletedIsFalse(String userId);
}
