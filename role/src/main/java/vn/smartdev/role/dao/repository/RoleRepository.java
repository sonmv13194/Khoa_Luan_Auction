package vn.smartdev.role.dao.repository;

import vn.smartdev.core.jpa.repository.AuditingRepository;
import org.springframework.stereotype.Repository;
import vn.smartdev.role.dao.entity.Role;

@Repository
public interface RoleRepository extends AuditingRepository<Role, String> {
}