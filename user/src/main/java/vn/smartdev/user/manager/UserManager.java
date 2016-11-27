package vn.smartdev.user.manager;


import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;

public interface UserManager {

    User findUserByUsername(String username) throws UserNotFoundException;
    User findUserById(String userId) throws UserNotFoundException;
    User createUser(User user) throws UserAlreadyExistsException;
    User enableUser(User user) throws UserNotFoundException;
    User updateUser(User user) throws UserNotFoundException, UserAlreadyExistsException;
    User changePassword(String userId, String newPassword) throws UserNotFoundException;
}
