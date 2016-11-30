package vn.smartdev.user.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import sun.invoke.empty.Empty;
import vn.smartdev.user.dao.entity.Role;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.repository.UserRepository;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import vn.smartdev.user.manager.UserManagerImpl;
import org.fest.assertions.Assertions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by levuhuy on 11/29/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserManagerImpl userManager;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldReturnTrueWhenFindUserByNameIsHuy() throws UserNotFoundException {
        User user;
        user = new User("Da nang", new Date(2000-12-12) ,"huyhaohoa@gmail."
                ,"","09052453445","Huy"
                ,true,true,true
                , true, new Role("ADMIN"));
        User expected =user;
        Mockito.when(userRepository.findByUsername("Huy")).thenReturn(user);
        User result =  userManager.findUserByUsername("Huy");

        Assertions.assertThat(result).isEqualTo(expected);

    }

    @Test
    public void shouldReturnTrueWhenCreateUser() throws UserAlreadyExistsException {
        User user;
        user = new User("Da nang", new Date(2000-12-12) ,"huyhaohoa@gmail."
                ,"","09052453445","Huy"
                ,true,true,true
                , true, new Role("ADMIN"));
        User expected =user;
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertThat(userManager.createUser(user)).isEqualTo(user);
    }

    @Test
    public void shouldReturnTrueWhenUpdateUser() throws UserAlreadyExistsException, UserNotFoundException {

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        User user = new User( "Huy");
        userManager.updateUser(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(argumentCaptor.capture());
    }

    @Test
    public void shouldReturTrueWhenDeleteUserWithUsernameIsHuy(){
        User user = new User("Huy");
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        //verify(userRepository.delete(argumentCaptor.capture()));
    }
}


