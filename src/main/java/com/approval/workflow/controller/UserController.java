package com.approval.workflow.controller;

import com.approval.workflow.model.User;
import com.approval.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> saveRegisteredUser(@Valid @RequestBody User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        User registeredUserToBeAdded = this.userService.saveRegisteredUser(user);
        if (registeredUserToBeAdded == null)
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.of(Optional.of(registeredUserToBeAdded));
    }


    @RequestMapping(value = "/byEmail", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByEmailId(@RequestParam("emailAddress") String emailId) {
        User existingUser = this.userService.findUserByEmail(emailId);
        if (existingUser == null)
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.of(Optional.of(existingUser));
    }


    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByEmailId(@RequestParam("userId") Integer id) {
        User existingUser = this.userService.findUserById(id);
        if (existingUser == null)
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.of(Optional.of(existingUser));
    }
}
