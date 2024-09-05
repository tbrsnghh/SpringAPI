package com.example.springapiuser.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User user) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setAge(user.getAge());
            existingUser.setPosition(user.getPosition());
            existingUser.setSkills(user.getSkills());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsersByIds(String[] ids) {
        List<User> users = new ArrayList<>();
        for (String id : ids) {
            User user = getUserById(id);
            if (user != null) {
                users.add(user);
            }
        }
        return users;
    }
}
