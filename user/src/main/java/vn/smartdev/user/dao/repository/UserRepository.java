package vn.smartdev.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.smartdev.user.dao.entity.User;

/**
 * Created by nxmt on 28/12/2016.
 */
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);

    int countByUsernameOrEmailOrPhoneAndIdNotIn(String username, String email, String phone, String id);

    User findByIdAndDeletedIsFalse(String userId);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.accountNonLocked = :accountNonLocked WHERE u.username = :username")
    public void updateLocked(@Param("username")String username, @Param("accountNonLocked")boolean accountNonLocked);
}