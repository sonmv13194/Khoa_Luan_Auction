package vn.smartdev.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vn.smartdev.user.dao.entity.Role;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.model.UserModel;
import vn.smartdev.user.dao.repository.RoleRepository;
import vn.smartdev.user.dao.repository.UserRepository;

import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  java.util.List;
import  java.util.ArrayList;
@Service
public class UserServiceImpl implements UserManager {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("Cannot find user by username: " + username);
        }
        logger.error("Excuted findUserByUsername method !!");
        return user;
    }

    @Override
    public User findUserById(String userId) throws UserNotFoundException {
        User user = userRepository.findByIdAndDeletedIsFalse(userId);
        if (user == null) {
            throw new UserNotFoundException("Cannot find user by id: " + userId);
        }
        logger.error("Excuted findUserById method !!");
        return user;
    }



//    public boolean userExists(User user) {
//        return userRepository.countByUsernameOrEmailOrPhoneAndIdNotIn(user.getUsername(),
//                user.getEmail(), user.getPhone(), user.getId()) > 0;
//    }
//
//    @Override
//    public User enableUser(User user) throws UserNotFoundException {
//        throw new NotImplementedException();
//    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public void save(UserModel userModel) {
        User user = new User();
        user.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        Role role = roleRepository.findByRoleName("ROLE_USER");
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
        userRepository.save(user);
        logger.error("Excuted save method !!");

    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public void saveForEdit(User user) {
       User userCurrent = userRepository.findOne(user.getId());
       userCurrent.setUsername(user.getUsername());
       userCurrent.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       userCurrent.setEmail(user.getEmail());
       userCurrent.setPhone(user.getPhone());
       userCurrent.setBirthday(user.getBirthday());
       userCurrent.setAddress(user.getAddress());
       userRepository.save(userCurrent);
       logger.error("Excuted saveForEdit method !!");
    }

    @Override
    public List<User> findAllUsers() {
        logger.error("Excuted findAllUser method !!");
        return userRepository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public void deleteUser(User user) throws UserNotFoundException {
        logger.error("Excuted deleteUser method !!");
        userRepository.delete(user);
    }

}
