package com.sunny.trellito.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User findUserById(Long id) {

        return repo.getReferenceById(id);
    }

    public User addUser(User user) {
        return repo.save(user);
    }

}
