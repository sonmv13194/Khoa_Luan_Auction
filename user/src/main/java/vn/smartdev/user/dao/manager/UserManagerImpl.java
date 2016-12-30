package vn.smartdev.user.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.repository.UserRepository;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;

import java.util.List;

/**
 * Created by levuhuy on 30/12/2016.
 */
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findUserById(String userId) throws UserNotFoundException {
        return userRepository.findOne(userId);
    }

    @Override
    public User save(User user) throws UserAlreadyExistsException{
        return userRepository.save(user);
    }

    @Override
    public User saveForEdit(User user) {
        return  userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(User user) throws UserNotFoundException {
        userRepository.delete(user);
    }
}
