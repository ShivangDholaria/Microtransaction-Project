package dev.transacts.model;

import org.json.simple.JSONObject;

import dev.transacts.entity.User;

@SuppressWarnings("unchecked")
public class Responces {
    private JSONObject obj = new JSONObject();

    /*
     * Methods to send Responses
     * 1.  BadRequestUserNotFound
     * 2.  BadRequestMesssageExists
     * 3.  BadRequestInvalidCurrency
     * 4.  BadRequestInvalidDebitOrCreditValue
     * 5.  BadRequestInvalidAmount
     * 6.  BadRequestServerDown
     * 7.  BadRequestInsufficientFunds
     * 8.  BadRequestNullPayload
     * 9.  BadRequestNoUserID
     * 10. BadRequestNoMessageID
     * 11. BadRequestNoAmount
     * 12. BadRequestNoDebitCreditValue
     * 13. approveAuthorizationMessage
     * 14. approveLoadMessage
     * 15. 
     */

    public JSONObject approveAuthorizationMessage(TransactionRequest auth, User user) {
        JSONObject balanceData = new JSONObject();
               
        //Main JSON Object
        obj.put("messageId", auth.getMessageId());
        obj.put("userId", user.getUserID());
        obj.put("responseCode", "APPROVED");

        //Inner JSON Object
        balanceData.put("amount", user.getBalance().toString());
        balanceData.put("curreny", auth.getTransactAmount().getCurrency());
        balanceData.put("debitOrCredit", auth.getTransactAmount().getDebitOrCredit());
        

        //Final JSON Object
        obj.put("balance", balanceData);

        return obj;
    }

    public JSONObject deniedAuthorizationMessage(TransactionRequest auth, User user) {        
        JSONObject balanceData = new JSONObject();
               
        //Inner JSON Object
        balanceData.put("amount", user.getBalance().toString());
        balanceData.put("curreny", auth.getTransactAmount().getCurrency());
        balanceData.put("debitOrCredit", auth.getTransactAmount().getDebitOrCredit());
        
        //Main JSON Object
        obj.put("messageId", auth.getMessageId());
        obj.put("userId", user.getUserID());
        obj.put("responseCode", "DENIED");

        //Final JSON Object
        obj.put("balance", balanceData);

        return obj;
    }

    public JSONObject approveLoadMessage(TransactionRequest auth, User user) {        
        JSONObject balanceData = new JSONObject();
               
        //Inner JSON Object
        balanceData.put("amount", user.getBalance().toString());
        balanceData.put("curreny", auth.getTransactAmount().getCurrency());
        balanceData.put("debitOrCredit", auth.getTransactAmount().getDebitOrCredit());
        
        //Main JSON Object
        obj.put("messageId", auth.getMessageId());
        obj.put("userId", user.getUserID());
        obj.put("responseCode", "APPROVED");

        //Final JSON Object
        obj.put("balance", balanceData);

        return obj;
    }

    public JSONObject BadRequestNoUserFound() {        
        //Main JSON Object
        obj.put("message","Bad Request: User not found");
        obj.put("code", "422");
        
        return obj;
    }


    public JSONObject BadRequestUserNotFound() {        
        //Main JSON Object
        obj.put("message","Bad Request: userId is null");
        obj.put("code", "422");
        
        return obj;
    }
    
    public JSONObject BadRequestMessageExists() {        
        //Main JSON Object
        obj.put("message","Bad Request: Transaction already exists");
        obj.put("code", "422");
        
        return obj;
    }
    
    public JSONObject BadRequestInvalidCurrency() {        
        //Main JSON Object
        obj.put("message","Bad Request: Not a valid currency");
        obj.put("code", "422");
        
        return obj;
    }

    public JSONObject BadRequestInvalidDebitOrCreditValue() {                       
        //Main JSON Object
        obj.put("message","Bad Request: Not a valid DEBIT or CREDIT value");
        obj.put("code", "422");
    
        return obj;
    }

    public JSONObject BadRequestInvalidAuthorization() {                       
        //Main JSON Object
        obj.put("message","Bad Request: Can't AUTHORIZE a CREDIT Transaction");
        obj.put("code", "422");
    
        return obj;
    }

    public JSONObject BadRequestInvalidLoad() {                       
        //Main JSON Object
        obj.put("message","Bad Request: Can't LOAD a DEBIT Transaction");
        obj.put("code", "422");
    
        return obj;
    }

    public JSONObject BadRequestNoAmount() {        
        //Main JSON Object
        obj.put("message","Bad Request: No amount is specified");
        obj.put("code", "422");
        
        return obj;
    }

    public JSONObject BadRequestInvalidAmount() {        
        //Main JSON Object
        obj.put("message","Bad Request: Amount should be a non-negative number");
        obj.put("code", "422");
        
        return obj;
    }

    public JSONObject BadRequestInvalidAmountDataType() {        
        //Main JSON Object
        obj.put("message","Bad Request: Invalid amount datatype. Should be a decimal datatype");
        obj.put("code", "422");
        
        return obj;
    }
    
    public JSONObject BadRequestServerDown() {        
        //Main JSON Object
        obj.put("message","Server is down. Please try again later");
        obj.put("code", "503");
        
        return obj;
    }
    
    public JSONObject BadRequestInsufficientFunds() {        
        //Main JSON Object
        obj.put("message","Could not proceed with the transaction as the funds are insufficient");
        obj.put("code", "51");
        
        return obj;
    }

    public JSONObject BadRequestNullPayload() {        
        //Main JSON Object
        obj.put("message","Bad Request: Payload is empty");
        obj.put("code", "422");
        
        return obj;
    }
    
    public JSONObject BadRequestNoUserID() {                       
        //Main JSON Object
        obj.put("message","Bad Request: userId is not mentioned");
        obj.put("code", "422");

        return obj;
    }

    public JSONObject BadRequestNoMessageID() {        
        //Main JSON Object
        obj.put("message","Bad Request: messageId is not mentioned");
        obj.put("code", "422");
        
        return obj;
    }
    
    public JSONObject BadRequestNoDebitCreditValue() {        
        //Main JSON Object
        obj.put("message","Bad Request: No CREDIT or DEBIT value mentioned");
        obj.put("code", "422");
        
        return obj;
    }

    public JSONObject BadRequestInvalidMessageID() {        
        //Main JSON Object
        obj.put("message","Bad Request: Invalid MessageID format");
        obj.put("code", "422");
        
        return obj;
    }

    public JSONObject BadRequestInvalidUserID() {        
        //Main JSON Object
        obj.put("message","Bad Request: Invalud UserID Format");
        obj.put("code", "422");
        
        return obj;
    }

}
