package com.bootcamp.springboot.Service;

import com.bootcamp.springboot.Model.User;
import com.bootcamp.springboot.Repository.IUserRepository;
import com.bootcamp.springboot.Service.Interface.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final IUserRepository iUserRepository;

    public UserServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username" + username + " not found.");
        } else if (!user.isActive()){
            throw new UsernameNotFoundException("Username is not active.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), loadAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> loadAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        logger.info("{}", user.getRoles().toArray());
        user.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return grantedAuthorities;
    }

    @Override
    public List<User> getAllUser() {
        return iUserRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        iUserRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = iUserRepository.findById(id);
        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new RuntimeException("To Do not found for id: " + id);
        }
        return user;
    }
}
