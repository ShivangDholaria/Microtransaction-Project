package dev.transacts.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.transacts.entity.User;
import dev.transacts.repository.UserRepository;
import dev.transacts.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User fetchUser(String userID) {
        return userRepository.findById(userID).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
    @Override
    public long getUserCount() {
        return userRepository.count();
    }
}
