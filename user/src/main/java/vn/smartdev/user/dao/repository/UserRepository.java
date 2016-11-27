package vn.smartdev.user.dao.repository;

import vn.smartdev.core.jpa.repository.AuditingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.smartdev.user.dao.entity.User;

public interface UserRepository extends AuditingRepository<User, String> {

    User findByUsername(String username);

    @Query("SELECT COUNT(u) FROM User u WHERE u.id != :id and (u.username = :username or u.email = :email or u.phoneNumber =:phoneNumber) ")
    int countByUsernameOrEmailOrPhoneAndIdNotIn(@Param("username") String username, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("id") String id);
}
