package dev.transacts.model;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;

import dev.transacts.service.EventLogger;

public class ResponseBodyCheck {

    public class BoolResponce {
        private boolean valid;
        private JSONObject response;

        public BoolResponce(boolean valid, JSONObject response) {
            this.valid = valid;
            this.response = response;
        }

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public JSONObject getResponse() {
            return response;
        }

        public void setResponse(JSONObject response) {
            this.response = response;
        }
    }
    // Methods to check the payload

    /*
     * For authorization request
     * 1. Check if messageID is unique
     * 2. Chech if userID is present in the userList
     * 3. Check if the transaction amount is non-negative number
     * 4. check is the currency is USD
     * 5. check is the request is DEBIT
     * 6. Check if messageId is a valid UUID
     * 7. Check if userId is a valid UUID
     * 
     * For load rerquest
     * 1. Check if messageID is unique
     * 2. Chech if userID is present in the userList
     * 3. Check if the transaction amount is non-negative number
     * 4. check is the currency is USD
     * 5. check is the request is CREDIT
     * 6. Check if messageId is a valid UUID
     * 7. Check if userId is a valid UUID
     * 
     */

    // ResponceObject responceObject = new ResponceObject();

    String uuidCheckPattern = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    String amountCheckPattern = "\\d*\\.?\\d*";

    Pattern uuidPattern = Pattern.compile(uuidCheckPattern);
    Pattern amountPattern = Pattern.compile(amountCheckPattern);

    // spellings 
    public BoolResponce checkPayloadForAuthorization(TransactionRequest auth, EventLogger e) {
        if (e.messageIDExists(auth.getMessageId()))
            return new BoolResponce(false, new Responces().BadRequestMessageExists());

        if (auth.getMessageId() == null)
            return new BoolResponce(false, new Responces().BadRequestNoMessageID());

        if (!uuidPattern.matcher(auth.getMessageId()).matches())
            return new BoolResponce(false, new Responces().BadRequestInvalidMessageID());
        
        if (auth.getUserId() == null)
            return new BoolResponce(false, new Responces().BadRequestUserNotFound());
        
        if (!uuidPattern.matcher(auth.getUserId()).matches())
            return new BoolResponce(false, new Responces().BadRequestInvalidUserID());
    
        if (auth.getTransactAmount() == null)
            return new BoolResponce(false, new Responces().BadRequestNullPayload());
        
        if (auth.getTransactAmount().getAmount() == null)
            return new BoolResponce(false, new Responces().BadRequestNoAmount());
    
        if (!amountPattern.matcher(auth.getTransactAmount().getAmount()).matches())
            return new BoolResponce(false, new Responces().BadRequestInvalidAmountDataType());
    
        if (new BigDecimal(auth.getTransactAmount().getAmount()).compareTo(BigDecimal.ZERO) == -1)
            return new BoolResponce(false, new Responces().BadRequestInsufficientFunds());
        
        if (auth.getTransactAmount().getCurrency().compareTo("USD") != 0)
            return new BoolResponce(false, new Responces().BadRequestInvalidCurrency());
    
        if (auth.getTransactAmount().getDebitOrCredit() == null)
            return new BoolResponce(false, new Responces().BadRequestNoDebitCreditValue());
        
        if (!auth.getTransactAmount().getDebitOrCredit().equalsIgnoreCase("debit"))
            return new BoolResponce(false, new Responces().BadRequestInvalidDebitOrCreditValue());

        return new BoolResponce(true, null);
    }

    public BoolResponce checkPayloadForLoad(TransactionRequest auth, EventLogger e) {

        if (e.messageIDExists(auth.getMessageId()))
            return new BoolResponce(false, new Responces().BadRequestMessageExists());
        if (auth.getMessageId() == null)
            return new BoolResponce(false, new Responces().BadRequestNoMessageID());
        if (!uuidPattern.matcher(auth.getMessageId()).matches())
            return new BoolResponce(false, new Responces().BadRequestInvalidMessageID());
        if (auth.getUserId() == null)
            return new BoolResponce(false, new Responces().BadRequestUserNotFound());
        if (!uuidPattern.matcher(auth.getUserId()).matches())
            return new BoolResponce(false, new Responces().BadRequestInvalidUserID());
        if (auth.getTransactAmount() == null)
            return new BoolResponce(false, new Responces().BadRequestNullPayload());
        if (auth.getTransactAmount().getAmount() == null)
            return new BoolResponce(false, new Responces().BadRequestNoAmount());
        if (!amountPattern.matcher(auth.getTransactAmount().getAmount()).matches())
            return new BoolResponce(false, new Responces().BadRequestInvalidAmountDataType());
        if (new BigDecimal(auth.getTransactAmount().getAmount()).compareTo(BigDecimal.ZERO) < 0)
            return new BoolResponce(false, new Responces().BadRequestInsufficientFunds());
        if (auth.getTransactAmount().getCurrency().compareTo("USD") != 0)
            return new BoolResponce(false, new Responces().BadRequestInvalidCurrency());
        if (auth.getTransactAmount().getDebitOrCredit() == null)
            return new BoolResponce(false, new Responces().BadRequestNoDebitCreditValue());
        if (!auth.getTransactAmount().getDebitOrCredit().equalsIgnoreCase("credit"))
            return new BoolResponce(false, new Responces().BadRequestInvalidDebitOrCreditValue());

        return new BoolResponce(true, null);
    }
}