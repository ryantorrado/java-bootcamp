package com.bootcamp.springboot.Controller;

import com.bootcamp.springboot.Model.User;
import com.bootcamp.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value ="/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = this.userService.GetAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/get-user-by-id")
    ResponseEntity<Object> getUserById(@RequestBody User user) {
        List<User> userById = this.userService.GetUserById(user.getUserCode());

        if (userById == null || userById.isEmpty()) {
            return new ResponseEntity<>("User Not Found.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userById, HttpStatus.OK);
        }
    }
}
