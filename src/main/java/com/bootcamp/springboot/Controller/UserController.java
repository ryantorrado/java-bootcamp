package com.bootcamp.springboot.Controller;

import com.bootcamp.springboot.Model.User;
import com.bootcamp.springboot.Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value ="/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("userList", userService.getAllUser());
        return "user-index";
    }

    @GetMapping("/add-user-form")
    public String addUserForm(Model model) {
        User adduser = new User();
        model.addAttribute("user", adduser);
        return "user-add";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user/";
    }

    @GetMapping("/update-user-form/{id}")
    public String updateUserForm(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        User user = userService.getUserById(id);
        user.setActive(false);
        userService.addUser(user);
        return "redirect:/user/";
    }
}
