package vn.smartdev.user.dao.manager;


import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.model.UserModel;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;

import java.util.List;

public interface UserManager {

    User findUserByUsername(String username) throws UserNotFoundException;
    User findUserById(String userId) throws UserNotFoundException;
    User save(User user) throws UserAlreadyExistsException;
    User saveForEdit(User user);
    List<User> findAllUsers();
    void deleteUser(User user) throws UserNotFoundException;


    /*User changePassword(String userId, String newPassword) throws UserNotFoundException;*/
}
