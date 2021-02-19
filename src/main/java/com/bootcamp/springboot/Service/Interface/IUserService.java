package com.bootcamp.springboot.Service.Interface;

import com.bootcamp.springboot.Model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    void addUser(User user);
    User getUserById(Long id);
    void updateUserDetails(Long id, String firstName, String lastName, boolean isActive);
}
