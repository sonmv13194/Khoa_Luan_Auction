package vn.smartdev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.smartdev.user.dao.entity.User;
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

}

