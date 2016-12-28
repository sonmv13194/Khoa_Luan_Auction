package vn.smartdev.user.dao.manager;
import vn.smartdev.user.dao.entity.Role;
import javax.management.relation.RoleNotFoundException;
import java.util.List;public interface RoleManager {
    List<Role> getAll();
    Role findRoleByName(String rolename) throws RoleNotFoundException;
}