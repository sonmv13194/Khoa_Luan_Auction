package vn.smartdev.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vn.smartdev.user.dao.entity.Role;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.manager.RoleManager;
import vn.smartdev.user.dao.model.UserModel;
import vn.smartdev.user.dao.repository.RoleRepository;
import vn.smartdev.user.dao.repository.UserRepository;

import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.dao.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.relation.RoleNotFoundException;
import  java.util.List;
import  java.util.ArrayList;
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private RoleManager roleManager;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByUsernameService(String username) {

        User user = null;
        try {
            user = userManager.findUserByUsername(username);
        } catch (UserNotFoundException e) {
            logger.error("User not found !");
        }
        logger.info("Excuted findUserByUsernameService method !!");
        return user;
    }

    @Override
    public User findUserByIdService(String userId){
        User user = null;
        try {
            user = userManager.findUserById(userId);
        } catch (UserNotFoundException e) {
            logger.error("User not found !");
        }
        logger.info("Excuted findUserByIdService method !!");
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public void saveService(UserModel userModel) {
        User user = new User();
        user.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        Role role = null;
        try {
            role = roleManager.findRoleByName("ROLE_USER");
        } catch (RoleNotFoundException e) {
           logger.error("Role not found !");
        }
        List<Role> roles = new ArrayList<>();
        user.setUsername(userModel.getUsername());
        user.setAddress(userModel.getAddress());
        user.setPhone(userModel.getPhone());
        user.setEmail(userModel.getEmail());
        user.setBirthday(userModel.getBirthday());
        roles.add(role);
        user.setRoles(roles);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        try {
            userManager.save(user);
        } catch (UserAlreadyExistsException e) {
            logger.error("User already exists");
        }
        logger.info("Excuted saveService method !!");

    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public void saveForEditService(User user) {
        User userCurrent = null;
        try {
            userCurrent = userManager.findUserById(user.getId());
        } catch (UserNotFoundException e) {
           //TODO
            logger.error("User not found !");
        }
        userCurrent.setUsername(user.getUsername());
        userCurrent.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userCurrent.setEmail(user.getEmail());
        userCurrent.setPhone(user.getPhone());
        userCurrent.setBirthday(user.getBirthday());
        userCurrent.setAddress(user.getAddress());
        userManager.saveForEdit(userCurrent);

        logger.info("Excuted saveForEditService method !!");
    }

    @Override
    public List<User> findAllUsersService() {
        logger.info("Excuted findAllUsersService method !!");
        return userManager.findAllUsers();
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public void deleteUserService(User user) {
        logger.info("Excuted deleteUserService method !!");

        try {
            userManager.deleteUser(user);
        } catch (UserNotFoundException e) {
            logger.error("User not found!");
        }

    }

}
