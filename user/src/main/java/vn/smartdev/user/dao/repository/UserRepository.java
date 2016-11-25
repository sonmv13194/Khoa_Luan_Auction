package vn.smartdev.user.dao.repository;

import com.java.training.core.jpa.repository.AuditingRepository;
import vn.smartdev.user.dao.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends AuditingRepository<User, String> {

    User findByUsername(String username);

    @Query("SELECT COUNT(u) FROM User u WHERE u.id != :id and (u.username = :username or u.email = :email or u.phoneNumber =:phoneNumber) ")
    int countByUsernameOrEmailOrPhoneAndIdNotIn(@Param("username") String username, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("id") String id);
}
