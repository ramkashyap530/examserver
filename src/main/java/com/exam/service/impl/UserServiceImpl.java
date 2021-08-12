package com.exam.service.impl;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoleSet) throws Exception {


        User localUser=this.userRepository.findByUsername(user.getUsername());
        if (localUser==null)
        {
            for (UserRole userRole:userRoleSet)
            {
                this.roleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoleSet);
            localUser=this.userRepository.save(user);
        }else{
            System.out.println("Username All Ready Present");
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, new Exception("Username All Ready Present"));
            throw new Exception("Username All Ready Present");
        }

        return localUser;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user)  {

        if(this.userRepository.findByUsername(user.getUsername())!=null)
        {return this.userRepository.save(user);}
        else{return null;}


    }
}
