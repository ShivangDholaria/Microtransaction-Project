package dev.transacts.controller;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.transacts.entity.Currencies;
import dev.transacts.entity.Events;
import dev.transacts.entity.User;
import dev.transacts.model.Balance;
import dev.transacts.model.Ping;
import dev.transacts.model.Responces;
import dev.transacts.model.ResponseBodyCheck;
import dev.transacts.model.TransactionRequest;
import dev.transacts.model.ValidTransactionRequest;
import dev.transacts.model.ResponseBodyCheck.BoolResponce;
import dev.transacts.service.Credit;
import dev.transacts.service.Debit;
import dev.transacts.service.EventLogger;
import dev.transacts.service.Impl.UserServiceImpl;
import dev.transacts.service.Impl.CurrencyServiceImpl;
import dev.transacts.service.Impl.EventsServiceImpl;

@RestController
public class MainApiClass {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private CurrencyServiceImpl currencyServiceImpl;

    @Autowired
    private EventsServiceImpl eventsServiceImpl;

    private EventLogger eventLogger;

    // Send responses back
    Responces createResponse = new Responces();
    ResponseBodyCheck responseBodyCheck = new ResponseBodyCheck();

    // Service objects
    Debit debit = new Debit();
    Credit credit = new Credit();


    public void AddCurrencies() {

        if(!currencyServiceImpl.fetchAllCurrencies().isEmpty())
            return;

        Set<Currency> currSet = Currency.getAvailableCurrencies();

        // Adding all currencies in the table
        for (Currency cur : currSet) {
            currencyServiceImpl.saveCurrencies(new Currencies(cur.getCurrencyCode(), cur.getDisplayName()));
        }
    }

    public void AddUsers() {
        if (userServiceImpl.getUserCount() == 0) {
            for (int i = 0; i < 10; i++) {
                // Generating Random initial balances
                BigDecimal bal = new BigDecimal((new Random().nextDouble(10000, 20000)));
                int bas = 0;
                switch (new Random().nextInt(1, 4)) {
                    case 1:
                        bas = 10;
                        break;

                    case 2:
                        bas = 100;
                        break;

                    case 3:
                        bas = 1000;
                        break;

                    case 4:
                        bas = 10000;
                        break;

                    default:
                        break;
                }

                BigDecimal remainder = bal.remainder(new BigDecimal(bas));
                bal = bal.subtract(remainder);

                // Creating UserID
                String UserID = UUID.randomUUID().toString();

                // Creating user in DB
                // Creating user in EventsServiceImpl
                userServiceImpl.saveUser(new User(UserID, bal));
            }

        }
    }

    @GetMapping("/")
    public String WelcomPage() {

        //Add code for adding currencies in the Dd
        AddCurrencies();
    
        //Add code for adding users in DB
        AddUsers();

        List<User> users = userServiceImpl.getAllUser();

        StringBuilder userIDs = new StringBuilder(
                "This is a starter page.</br> The following are the userIDs present to use the API.</br></br>");
        for (User user : users) {
            userIDs.append(user.getUserID()).append("</br>");
        }

        return userIDs.toString();
    }

    @GetMapping("/ping")
    public ResponseEntity<JSONObject> callPing() {
        return ResponseEntity.ok(new Ping().ping());
    }

    @PutMapping("/authorization")
    public ResponseEntity<JSONObject> authorize(@RequestBody TransactionRequest auth) {

        BoolResponce requestBody = responseBodyCheck.checkPayloadForAuthorization(auth, eventsServiceImpl);

        if (!requestBody.isValid())
            return ResponseEntity.badRequest().body(requestBody.getResponse());

        ValidTransactionRequest authRequest = new ValidTransactionRequest(
                                                    auth.getMessageId(),
                                                    auth.getUserId(),
                                                    new Balance(auth.getTransactAmount().getAmount(),
                                                            auth.getTransactAmount().getCurrency(),
                                                            auth.getTransactAmount().getDebitOrCredit()));

        // Code to debit amount
        User concernedUser = userServiceImpl.fetchUser(auth.getUserId());

        // User object check
        if (concernedUser == null)
            return ResponseEntity.badRequest().body(new Responces().BadRequestNoUserFound());

        if(debit.debitAmount(concernedUser, authRequest.getValidTransactAmount().getAmount())) {

            eventLogger.logTransactionEvent(authRequest.getUserId(), new Events("AUTHORIZATION",
                    authRequest.getMessageId(),
                    authRequest.getUserId(),
                    authRequest.getValidTransactAmount().getDebitOrCredit(),
                    authRequest.getValidTransactAmount().getAmount(),
                    "APPROVED",
                    concernedUser.getBalance().toString(),
                    new Ping().getTimeStamp()));

            return ResponseEntity.ok().body(createResponse.approveAuthorizationMessage(auth, concernedUser));
        } else {
            eventLogger.logTransactionEvent(authRequest.getUserId(), new Events("AUTHORIZATION",
                    authRequest.getMessageId(),
                    authRequest.getUserId(),
                    authRequest.getValidTransactAmount().getDebitOrCredit(),
                    authRequest.getValidTransactAmount().getAmount(),
                    "DENIED",
                    concernedUser.getBalance().toString(),
                    new Ping().getTimeStamp()));

            return ResponseEntity.ok().body(createResponse.deniedAuthorizationMessage(auth, concernedUser));

        }
    }

    @PutMapping("/load")
    public ResponseEntity<JSONObject> load(@RequestBody TransactionRequest auth) {

        BoolResponce requestBody = responseBodyCheck.checkPayloadForLoad(auth, eventsServiceImpl);

        if (!requestBody.isValid())
        return ResponseEntity.badRequest().body(requestBody.getResponse());

        ValidTransactionRequest authRequest = new ValidTransactionRequest(auth.getMessageId(),
                                                    auth.getUserId(),
                                                    new Balance(
                                                        auth.getTransactAmount().getAmount(),
                                                        auth.getTransactAmount().getCurrency(),
                                                        auth.getTransactAmount().getDebitOrCredit()));

        // User check in Database
        User concernedUser = userServiceImpl.fetchUser(auth.getUserId());

        if (concernedUser == null)
            return ResponseEntity.badRequest().body(new Responces().BadRequestNoUserFound());

        // Credit amount
        credit.creditAmount(concernedUser, authRequest.getValidTransactAmount().getAmount());

        eventLogger.logTransactionEvent(authRequest.getUserId(), 
                                        new Events("LOAD",
                                                    authRequest.getMessageId(),
                                                    authRequest.getUserId(),
                                                    authRequest.getValidTransactAmount().getDebitOrCredit(),
                                                    authRequest.getValidTransactAmount().getAmount(),
                                                    "APPROVED",
                                                    concernedUser.getBalance().toString(),
                                                    new Ping().getTimeStamp()));

        return ResponseEntity.ok().body(createResponse.approveLoadMessage(auth, concernedUser));
    }

}
