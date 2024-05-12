package dev.transacts.entity;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Events class represents a transaction event in the system.
 * It contains information such as action, message ID, user ID, debit or credit,
 * transaction amount, response code, balance, other message, and timestamp.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Events {
    
    @Column(name = "action")
    private String action;

    @Column(name = "message_id")
    private String messageID;

    @Id
    @Column(name = "user_id")
    private String userID;

    @Column(name = "debit_or_credit")
    private String debitOrCredit;

    @Column(name = "response_code")
    private String responseCode;

    @Column(name = "balance")
    private String balance;

    @Column(name = "timestamp")
    private String timeStamp;

    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;
    
    /**
     * Gets the timestamp of the event.
     * @return The timestamp of the event.
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the timestamp of the event.
     * @param timeStamp The timestamp of the event.
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    /**
     * Gets the action of the event.
     * @return The action of the event.
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the action of the event.
     * @param action The action of the event.
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Gets the message ID of the event.
     * @return The message ID of the event.
     */
    public String getMessageID() {
        return messageID;
    }

    /**
     * Sets the message ID of the event.
     * @param messageID The message ID of the event.
     */
    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    /**
     * Gets the user ID of the event.
     * @return The user ID of the event.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the user ID of the event.
     * @param userID The user ID of the event.
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Gets the debit or credit of the event.
     * @return The debit or credit of the event.
     */
    public String getDebitOrCredit() {
        return debitOrCredit;
    }

    /**
     * Sets the debit or credit of the event.
     * @param debitOrCredit The debit or credit of the event.
     */
    public void setDebitOrCredit(String debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    /**
     * Gets the response code of the event.
     * @return The response code of the event.
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the response code of the event.
     * @param responseCode The response code of the event.
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * Gets the balance of the event.
     * @return The balance of the event.
     */
    public String getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the event.
     * @param balance The balance of the event.
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * Gets the transaction amount of the event.
     * @return The transaction amount of the event.
     */
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the transaction amount of the event.
     * @param transactionAmount The transaction amount of the event.
     */
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * Constructor for the Events class with parameters.
     * @param action The action of the event.
     * @param messageID The message ID of the event.
     * @param userID The user ID of the event.
     * @param debitOrCredit The debit or credit of the event.
     * @param transactionAmount The transaction amount of the event.
     * @param responseCode The response code of the event.
     * @param balance The balance of the event.
     * @param timeStamp The timestamp of the event.
     */
    public Events( String action, String messageID, 
                   String userID, String debitOrCredit,
                   BigDecimal transactionAmount, 
                   String responseCode, String balance,
                   String timeStamp) {      
        this.action = action;
        this.messageID = messageID;
        this.userID = userID;
        this.debitOrCredit = debitOrCredit;
        this.responseCode = responseCode;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
        this.timeStamp = timeStamp;
    }

    /**
     * Returns a string representation of the Events object.
     * @return A string representation of the Events object.
     */
    @Override
    public String toString() {
        return "Events{" +
                "action='" + action + '\'' +
                ", messageID='" + messageID + '\'' +
                ", userID='" + userID + '\'' +
                ", debitOrCredit='" + debitOrCredit + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", balance='" + balance + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
