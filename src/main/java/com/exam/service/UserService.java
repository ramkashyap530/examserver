package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;

public interface UserService {

    // Create User
    public User createUser(User user, Set<UserRole> userRoleSet) throws Exception;

    // getUser by username
   public User getUser(String username);

    public void deleteUser(Long userId);

    public User updateUser(User user);
}
