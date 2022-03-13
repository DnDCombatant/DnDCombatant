package com.combatant.service;

import java.util.List;

import com.combatant.model.User;

public interface LoginService {

   List<User> findAllUsers();

   User findByUsername(String username, String password);

    void saveUser(User user);

}