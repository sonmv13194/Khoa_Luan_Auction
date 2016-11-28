package vn.smartdev.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.smartdev.user.dao.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}