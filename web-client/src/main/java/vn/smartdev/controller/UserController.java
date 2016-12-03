package vn.smartdev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.smartdev.user.dao.entity.Role;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.manager.RoleManager;
import vn.smartdev.user.manager.UserManager;

import javax.management.relation.RoleNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by levuhuy on 11/29/16.
 */

@Controller
@RequestMapping(value = "/admin")
public class UserController {

    @Autowired
    UserManager userManager;

    @Autowired
    RoleManager roleManager;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/viewUser", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        List<User> users = userManager.findAllUsers();
        model.addAttribute("listUser",users);
        List<Role> roles = roleManager.getAll();
        model.addAttribute("listRole", roles);
        return "viewUserPage";
    }

    @RequestMapping(value = "/editUser")
    public String editUser(@RequestParam("id") String uid, Model model){

        User user = null;
        try {
            user = userManager.findUserById(uid);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        List<User> users = userManager.findAllUsers();
        model.addAttribute("listUser",users);
        model.addAttribute("user", user);
        List<Role> roles = roleManager.getAll();
        model.addAttribute("listRole", roles);
        return "viewUserPage";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") String id, Model model){
        try {
            userManager.deleteUser(userManager.findUserById(id));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:viewUser";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request) throws ParseException, UserAlreadyExistsException, RoleNotFoundException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email    = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String address  = request.getParameter("address");
        String phone  = request.getParameter("phone");
        String role  = request.getParameter("optradio");
        SimpleDateFormat formatter = new SimpleDateFormat(birthday);
            Date birthdayFormat = formatter.parse(birthday);
            User user = new User(address, birthdayFormat ,email,password,phone,username);
            List<Role> roles = new ArrayList<>();
            roles.add(roleManager.findRoleByName(role));
            user.setRoles(roles);
            System.out.print("User name : "+username+" Pass : "+password+" Email  : "+email+" Birthay : "+birthday
            +" address: "+address+ " Role: "+role);
            userManager.createUser(user);
        return "redirect:viewUser";
    }

}

