package dev.transacts.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

public class User {

    private static User userInstance;
    public List<User> userList;

    private String UserID;
    private BigDecimal balance;

    
    User() {
        userList = new ArrayList<>();
    }
    
    //
    public User(String userID, BigDecimal balance) {
        UserID = userID;
        this.balance = balance;
    }
    
    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    //
    public static User getInstance() {
        if (userInstance == null) {
            userInstance = new User();
        }
        return userInstance;
    }

    //
    public User getUser(String userID) {
        for (User user : userList) {
            if (user.UserID.equals(userID)) {
                return user;
            }
        }
        return null;
    }

    public int getUserListLength() {
        return userList.size();
    }
    
    public void addUser(String userID, BigDecimal balance) {
        userList.add(new User(userID, balance));
    }

}
