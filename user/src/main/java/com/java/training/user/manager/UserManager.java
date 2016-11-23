package com.java.training.user.manager;

import com.java.training.user.dao.entity.User;
import com.java.training.user.exception.UserAlreadyExistsException;
import com.java.training.user.exception.UserNotFoundException;

public interface UserManager {

    User findUserByUsername(String username) throws UserNotFoundException;
    User findUserById(String userId) throws UserNotFoundException;
    User createUser(User user) throws UserAlreadyExistsException;
    User enableUser(User user) throws UserNotFoundException;
    User updateUser(User user) throws UserNotFoundException, UserAlreadyExistsException;
    User changePassword(String userId, String newPassword) throws UserNotFoundException;
}
