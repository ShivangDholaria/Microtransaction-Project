package dev.transacts.service;

import java.util.List;

import dev.transacts.entity.User;

public interface UserService {
    
    //Save operation
    User saveUser(User user);

    //Get operation
    User fetchUser(String userID);

    //update operation
    User updateUser(User user);

    // Get all user
    List<User> getAllUser();

    //Get user count
    long getUserCount();

}
