package com.exam.service.impl;

import com.exam.model.User;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

   // @Autowired
   // private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = this.userService.getUser(username);
        if (user==null)
        {
            System.out.println("User Not Found..");
            throw new UsernameNotFoundException("Not User Found !!");
        }
        return  user;


    }
}
