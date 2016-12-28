package vn.smartdev.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.smartdev.user.dao.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
   // @Query("SELECT r FROM Role r WHERE r.role_name= ?1")
    Role findByRoleName(String rolename);
}