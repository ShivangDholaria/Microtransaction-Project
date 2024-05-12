package dev.transacts.model;


public class ValidTransactionRequest {

    //Variable to set them as requests come in
    private String messageId;
    private String userId;
    private Balance validTransactionAmount;

    public ValidTransactionRequest(String messageId, String userId, Balance validTransactionAmount) {
        this.messageId = messageId;
        this.userId = userId;
        this.validTransactionAmount = validTransactionAmount;
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

    public Balance getValidTransactAmount() {
        return validTransactionAmount;
    }

    public void setValidTransactAmount(Balance validTransactionAmount) {
        this.validTransactionAmount = validTransactionAmount;
    }


    @Override
    public String toString() {
        return "AuthorizationRequest{" +
                "messageId='" + messageId + '\'' +
                ", userId='" + userId + '\'' +
                ", transactionAmount=" + validTransactionAmount.toString() +
                '}';
    }

}
