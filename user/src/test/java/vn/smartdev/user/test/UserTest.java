package vn.smartdev.user.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.mockito.runners.MockitoJUnitRunner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.smartdev.user.dao.entity.Role;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.model.UserModel;
import vn.smartdev.user.dao.repository.UserRepository;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.manager.UserManagerImpl;
import org.fest.assertions.Assertions;

import java.sql.Date;


/**
 * Created by levuhuy on 11/29/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @InjectMocks
    private UserManagerImpl userManager;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldReturnTrueWhenFindUserByNameIsHuy() throws UserNotFoundException {
        User user;
        user = new User("Da nang", new Date(2000 - 12 - 12), "huyhaohoa@gmail."
                , "", "09052453445", "Huy"
                , true, true, true
                , true, new Role("ROLE_ADMIN"));
        User expected = user;
        Mockito.when(userRepository.findByUsername("Huy")).thenReturn(user);
        User result = userManager.findUserByUsername("Huy");

        Assertions.assertThat(result).isEqualTo(expected);

    }


    public void shouldReturnTrueWhenCreateUser() throws UserAlreadyExistsException {
        UserModel userModel = new UserModel("Da Nang", new Date(2000 - 12 - 12), "huy@gmail.com",
                "123456", "01122434224", "huyle", "huyle");

        userManager.save(userModel);

        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        user.setAddress(userModel.getAddress());
        user.setPhone(userModel.getPhone());
        user.setEmail(userModel.getEmail());
        user.setBirthday(userModel.getBirthday());

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userRepository, Mockito.times(1)).save(argumentCaptor.capture());

    }

    @Test
    public void shouldReturnTrueWhenUpdateUser() throws UserAlreadyExistsException, UserNotFoundException {

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        User user = new User("Huy");
        userManager.updateUser(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(argumentCaptor.capture());
    }

    @Test
    public void shouldReturTrueWhenDeleteUserWithUsernameIsHuy() throws UserNotFoundException {
        User user = new User("Da nang", new Date(2000 - 12 - 12), "huyhaohoa@gmail."
                ,"", "09052453445", "Huy"
                ,true, true, true
                ,true, new Role("ROLE_ADMIN"));
        userManager.deleteUser(user);
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userRepository, Mockito.times(1)).delete(argumentCaptor.capture());
    }
}


