package vn.smartdev.user.services;

import vn.smartdev.user.dao.entity.Role;

import java.util.List;

/**
 * Created by levuhuy on 30/12/2016.
 */
public interface RoleService {

    List<Role> getAllRoleService();
    Role findRoleByName(String rolename);
}
