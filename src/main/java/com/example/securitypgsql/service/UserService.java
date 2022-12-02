package com.example.securitypgsql.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securitypgsql.repositories.UserRepository;
import com.example.securitypgsql.entities.User;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        UserDetailsPrincipal userDetailsPrincinpal = new UserDetailsPrincipal(user);

        return userDetailsPrincinpal;
    }
    
    public User addUser(User user) {
    	return userRepository.save(user);
    }
}