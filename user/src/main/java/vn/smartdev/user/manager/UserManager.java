package vn.smartdev.user.manager;


import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;

import java.text.ParseException;
import java.util.List;

public interface UserManager {

    User findUserByUsername(String username) throws UserNotFoundException;
    User findUserById(String userId) throws UserNotFoundException;
   // User createUser(User user) throws UserAlreadyExistsException;
    User enableUser(User user) throws UserNotFoundException;
    User updateUser(User user) throws UserNotFoundException, UserAlreadyExistsException;
    void save(User user);
    void saveForEdit(User user);
    List<User> findAllUsers();
    void deleteUser(User user) throws UserNotFoundException;


    /*User changePassword(String userId, String newPassword) throws UserNotFoundException;*/
}
