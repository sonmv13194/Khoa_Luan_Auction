package vn.smartdev.user.manager;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.repository.UserRepository;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;

import java.util.Calendar;
import java.util.List;

@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("Cannot find user by username: " + username);
        }
        return user;
    }

    @Override
    public User findUserById(String userId) throws UserNotFoundException {
        User user = userRepository.findByIdAndDeletedIsFalse(userId);
        if (user == null) {
            throw new UserNotFoundException("Cannot find user by id: " + userId);
        }
        return user;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public User createUser(User user) throws UserAlreadyExistsException {
        if (userExists(user)) {
            throw new UserAlreadyExistsException();
        }
        /*PasswordHistory passwordHistory = user.getPasswordHistory();
        passwordHistory.addPassword(user.getPassword());
        passwordHistory.setLastPasswordChanged(Calendar.getInstance().getTime());*/
        user.setEnabled(false);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        return userRepository.save(user);
    }

    public boolean userExists(User user) {
        return userRepository.countByUsernameOrEmailOrPhoneAndIdNotIn(user.getUsername(),
                user.getEmail(), user.getPhone(), user.getId()) > 0;
    }

    @Override
    public User enableUser(User user) throws UserNotFoundException {
        throw new NotImplementedException();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public User updateUser(User user) throws UserNotFoundException, UserAlreadyExistsException {
        if (userExists(user)) {
            throw new UserAlreadyExistsException(
                    "User already exists with email id: " + user.getEmail()
                            + " and/or phone number: "
                            + user.getPhone() + " and/or username: " + user.getUsername());
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /*@Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = false)
    public User changePassword(String userId, String newPassword) throws UserNotFoundException {
        User user = findUserById(userId);
        PasswordHistory passwordHistory = user.getPasswordHistory();
        passwordHistory.addPassword(newPassword);
        passwordHistory.setLastPasswordChanged(Calendar.getInstance().getTime());
        user.setPassword(newPassword);
        return userRepository.save(user);
    }*/
}
