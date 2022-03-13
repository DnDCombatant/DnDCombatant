package com.combatant.service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.combatant.model.User;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static{
        users = populateDummyUsers();
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findByUsername(String username, String password) {
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"markmocek", "markmocek"));
        users.add(new User(counter.incrementAndGet(),"admin", "password"));
        users.add(new User(counter.incrementAndGet(),"user", "user"));
        return users;
    }
}
