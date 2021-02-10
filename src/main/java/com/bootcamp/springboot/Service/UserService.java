package com.bootcamp.springboot.Service;

import com.bootcamp.springboot.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    public List<User> GetAllUsers() {
        List<User> user = new ArrayList<>();
        user.add(new User("user001", "Ryan", "Torrado", ""));
        user.add(new User("user002", "Joseph", "Torrado", ""));
        return user;
    }

    public List<User> GetUserById(String userCode) {
        List<User> user = new ArrayList<>();
        user.add(new User("user001", "Ryan", "Torrado", ""));
        user.add(new User("user002", "Joseph", "Torrado", ""));
        return user.stream().filter(x -> x.getUserCode().equalsIgnoreCase(userCode)).collect(Collectors.toList());
    }
}
