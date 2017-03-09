package vn.smartdev.user.dao.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import vn.smartdev.user.dao.entity.Role;
import vn.smartdev.user.dao.repository.RoleRepository;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

/**
 * Created by levuhuy on 30/12/2016.
 */
@Component
public class RoleManagerImpl implements RoleManager {


    @Autowired
    private  RoleRepository roleRepository;

    @Override
    public List<Role> getAll() throws RoleNotFoundException {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleByName(String rolename) throws RoleNotFoundException {
        return roleRepository.findOne(rolename);
    }
}
