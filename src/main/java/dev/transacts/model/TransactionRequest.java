package dev.transacts.model;

public class TransactionRequest {

    //Variable to set them as requests come in
    private String messageId;
    private String userId;
    private TransactionAmount transactionAmount;

    public TransactionRequest(String messageId, String userId, TransactionAmount transactionAmount) {
        this.messageId = messageId;
        this.userId = userId;
        this.transactionAmount = transactionAmount;
    }


    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageID) {
        this.messageId = messageID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userID) {
        this.userId = userID;
    }

    public TransactionAmount getTransactAmount() {
        return transactionAmount;
    }

    public void setTransactAmount(TransactionAmount transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "AuthorizationRequest{" +
                "messageId='" + messageId + '\'' +
                ", userId='" + userId + '\'' +
                ", transactionAmount=" + transactionAmount.toString() +
                '}';
    }

}
