package dev.transacts.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a User entity in the system.
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private String UserID;

    @Column(name = "balance")
    private BigDecimal balance;

    /**
     * Parameterized constructor for User class.
     * @param userID The ID of the user.
     * @param balance The balance of the user.
     */
    public User(String userID, BigDecimal balance) {
        UserID = userID;
        this.balance = balance;
    }

    /**
     * Retrieves the ID of the user.
     * @return The ID of the user.
     */
    public String getUserID() {
        return UserID;
    }

    /**
     * Sets the ID of the user.
     * @param userID The ID of the user.
     */
    public void setUserID(String userID) {
        UserID = userID;
    }

    /**
     * Retrieves the balance of the user.
     * @return The balance of the user.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the user.
     * @param balance The balance of the user.
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
