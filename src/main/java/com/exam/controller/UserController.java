package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("")
    public User createUser(@RequestBody User user) throws Exception {

        Role role=new Role();

        role.setRoleId(2L);
        role.setRoleName("NORMAL");
        user.setPassword(this .bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> userRoleSet=new HashSet<>();
        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleSet.add(userRole);

        return this.userService.createUser(user,userRoleSet);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username)
    {
        User lUser=this.userService.getUser(username);

        if(lUser==null)
        {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.of(Optional.of(lUser));
        }
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId)
    {
        this.userService.deleteUser(userId);
    }


    @PostMapping("/update")
    public User updateUser(@RequestBody User user)
    {
        return  this.userService.updateUser(user);
    }


}
