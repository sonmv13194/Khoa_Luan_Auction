package vn.smartdev.user.services;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.smartdev.user.dao.entity.Role;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.manager.RoleManager;
import vn.smartdev.user.dao.manager.UserManager;
import vn.smartdev.user.dao.model.UserModel;
import vn.smartdev.user.dao.repository.RoleRepository;
import vn.smartdev.user.dao.repository.UserRepository;
import vn.smartdev.user.exception.UserNotFoundException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by levuhuy on 12/26/16.
 */
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceIml;

    @Mock
    private UserManager userManager;

    @Mock
    private RoleManager roleManager;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findUserByUsernameService() throws Exception {
        User user;
        user = new User("Da nang", new Date(2000 - 12 - 12), "huyhaohoa@gmail."
                , "", "09052453445", "Huy"
                , true, true, true
                , true, new Role("ROLE_ADMIN"));

    Mockito.when(userManager.findUserByUsername("Huy")).thenReturn(user);


        User result = userServiceIml.findUserByUsernameService("Huy");
        Assertions.assertThat(result).isEqualTo(user);
    }

    @Test
    public void findUserByIdService() throws Exception {
        User user;
        user = new User("Da nang", new Date(2000 - 12 - 12), "huyhaohoa@gmail."
                , "", "09052453445", "Huy"
                , true, true, true
                , true, new Role("ROLE_ADMIN"));

        Mockito.when(userManager.findUserById("001")).thenReturn(user);
        User result = userServiceIml.findUserByIdService("001");
        Assertions.assertThat(result).isEqualTo(user);
    }

    @Test
    public void saveService() throws Exception {
        UserModel userModel = new UserModel("Ha Noi", new Date(2000-12-12), "huy@gmail.com",
                "1234", "0123223423", "huy.le", "huy.le");

        User user = new User();
        user.setId(userModel.getId());
        user.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        Role role = new Role("ROLE_USER");
        Mockito.when(roleManager.findRoleByName("ROLE_USER")).thenReturn(role);

        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setUsername(userModel.getUsername());
        user.setAddress(userModel.getAddress());
        user.setPhone(userModel.getPhone());
        user.setEmail(userModel.getEmail());
        user.setBirthday(userModel.getBirthday());
        user.setRoles(roles);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        Mockito.when(userManager.save(user)).thenReturn(user);
        userServiceIml.saveService(userModel);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userManager, Mockito.times(1)).save(argumentCaptor.capture());
    }

    @Test
    public void saveForEditService() throws Exception {
        User user = new User("Da nang", new Date(2000 - 12 - 12), "huyhaohoa@gmail.com"
                , "", "09052453445", "Huy"
                , true, true, true
                , true, new Role("ROLE_ADMIN"));
        Mockito.when(userManager.findUserById(user.getId())).thenReturn(user);
        User currentUser = user;
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setEmail(user.getEmail());
        currentUser.setBirthday(user.getBirthday());
        currentUser.setAddress(user.getAddress());

        userServiceIml.saveForEditService(currentUser);
        Mockito.when(userManager.save(currentUser)).thenReturn(currentUser);
        Assertions.assertThat(currentUser.getId()).isEqualTo(user.getId());
    }

    @Test
    public void findAllUsersService() throws Exception {
        List<User> users = createUser(5);
        Mockito.when(userManager.findAllUsers()).thenReturn(users);
        Assertions.assertThat(userServiceIml.findAllUsersService()).isEqualTo(users);
    }

    @Test
    public void deleteUserService() throws Exception {
        User user;
        user = new User("Da nang", new Date(2000 - 12 - 12), "huyhaohoa@gmail.com"
                , "", "09052453445", "Huy"
                , true, true, true
                , true, new Role("ROLE_ADMIN"));
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        userServiceIml.deleteUserService(user);

        Mockito.verify(userManager, Mockito.times(1)).deleteUser(userArgumentCaptor.capture());
        Assertions.assertThat(userArgumentCaptor.getValue()).isEqualTo(user);
    }

    private List<User> createUser(int numberOfUserWantCreate){
        List<User> users = new ArrayList<>();
        for (int i =1; i <= numberOfUserWantCreate; i++){
            User user = new User();

            user.setUsername("Huy "+i);
            user.setPassword(bCryptPasswordEncoder.encode("123"));
            user.setEmail("huy"+i+"@gmail.com");
            user.setBirthday(new Date(2000-12-12));
            user.setAddress("Da nang"+i);
            user.setEnabled(true);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);

            users.add(user);
        }
        return users;
    }
}