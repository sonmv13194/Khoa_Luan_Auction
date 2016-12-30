package vn.smartdev.user.services;

import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.model.UserModel;
import vn.smartdev.user.exception.UserNotFoundException;

import java.util.List;

/**
 * Created by levuhuy on 30/12/2016.
 */
public interface UserService {
    User findUserByUsernameService(String username);
    User findUserByIdService(String userId);
    void saveService(UserModel userModel);
    void saveForEditService(User user);
    List<User> findAllUsersService();
    void deleteUserService(User user) throws UserNotFoundException;
}
