package vn.smartdev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.smartdev.user.dao.entity.Role;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.dao.manager.RoleManager;
import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.dao.manager.UserManager;
import vn.smartdev.user.services.RoleService;
import vn.smartdev.user.services.UserService;

import java.text.ParseException;
import java.util.List;

/**
 * Created by levuhuy on 11/29/16.
 */

@Controller
@RequestMapping(value = "/admin")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/viewUser", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        List<User> users = userService.findAllUsersService();
        model.addAttribute("listUser",users);
        List<Role> roles = roleService.getAllRoleService();
        model.addAttribute("listRole", roles);
        model.addAttribute("user", new User());
        return "viewUserPage";

    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUserGet(@RequestParam("id") String uid, Model model){
        logger.info("Access editUserGet method !!");
        User user = userService.findUserByIdService(uid);
        List<User> users = userService.findAllUsersService();
        model.addAttribute("listUser",users);
        model.addAttribute("user", user);

        return "viewUserPage";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUserPost(@ModelAttribute User user, Model model) throws ParseException {
        logger.info("Access editUserPost method !!");
//        if (bindingResult.hasErrors()) {
//            // handle error
//            logger.error("===Got error");
//        } else {
//            logger.info("=== No error");
//
//        }
        userService.saveForEditService(user);
        List<User> users = userService.findAllUsersService();
        model.addAttribute("listUser",users);
        model.addAttribute("user", user);

        return "viewUserPage";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") String id) throws UserNotFoundException {
        logger.info("Access deleteUser method !!");

        userService.deleteUserService(userService.findUserByIdService(id));
        return "redirect:viewUser";
    }
}

