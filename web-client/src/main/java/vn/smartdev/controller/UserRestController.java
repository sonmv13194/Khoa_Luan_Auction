package vn.smartdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.smartdev.user.dao.entity.User;
import vn.smartdev.user.exception.UserAlreadyExistsException;
import vn.smartdev.user.exception.UserNotFoundException;
import vn.smartdev.user.manager.UserManager;

import java.util.List;

/**
 * Created by levuhuy on 12/8/16.
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    UserManager userManager;

    //-------------------Retrieve All Users------------------
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userManager.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    //-------------------Retrieve Single Users------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") String id) throws UserNotFoundException {
        User user = userManager.findUserById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // -------------------Create a Users------------------
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,
                                           UriComponentsBuilder ucBuilder) throws UserAlreadyExistsException {
        userManager.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    // -------------------Update a Users------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") String id,
                                           @RequestBody User user) throws UserNotFoundException {
        System.out.println("Updating user: "+id);
        userManager.saveForEdit(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    //------------------- Delete a User -------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) throws UserAlreadyExistsException, UserNotFoundException {
        System.out.println("Fetching & Deleting User with id " + id);
        User user = userManager.findUserById(id);
        userManager.deleteUser(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

//    //------------------- Delete all User -------------------
//    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteAllUser(){
//        System.out.println("Deleting All Users");
//        userManager.deleteAllUsers();
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//
//    }

}

