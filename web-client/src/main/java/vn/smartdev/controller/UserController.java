package vn.smartdev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.manager.UserManager;

import java.util.List;

/**
 * Created by levuhuy on 11/29/16.
 */

@Controller
@RequestMapping(value = "/admin")
public class UserController {

    @Autowired
    UserManager userManager;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/viewUser", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        List<User> users = userManager.findAllUsers();
        model.addAttribute("listUsers",users);
        return "viewUserPage";
    }

    @RequestMapping(value = "/editUser/{uid}")
    public String updateUser(@PathVariable("uid") String uid, Model model){

        User user = null;
        try {
            user = userManager.findUserById(uid);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("user", user);

        try {
            userManager.updateUser(user);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        }

        return "viewUserPage";  //TODO
    }

    @RequestMapping(value = "/deleteUser/{uid}")
    public String deleteUser(@PathVariable("uid") String uid, Model model){
        try {
            userManager.deleteUser(userManager.findUserById(uid));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return "viewUserPage";  //TODO
    }
    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String getcreateUserForm(Model model){

        return "viewUserPage";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(User user, Model model){
        try {
            userManager.createUser(user);
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        }
        return "viewUserPage";
    }

}

