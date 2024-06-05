package dev.transacts.controller;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

@RestController
public class MainApiClass {
    // Send responses back
    Responces createResponse = new Responces();
    ResponseBodyCheck responseBodyCheck = new ResponseBodyCheck();

    // Service objects
    Debit debit = new Debit();
    Credit credit = new Credit();


    @GetMapping("/")
    public String WelcomPage() {

        String userIDs = "This is a starter page.</br> The following are the userIDs present to use the API.</br>";

        return userIDs;
    }

    @GetMapping("/ping")
    public ResponseEntity<JSONObject> callPing() {
        return ResponseEntity.ok(new Ping().ping());
    }

    @SuppressWarnings("unused")
    @PutMapping("/authorization")
    public ResponseEntity<JSONObject> authorize(@RequestBody TransactionRequest auth) {

        // BoolResponce res = responseBodyCheck.checkPayloadForAuthorization(auth);

        // if (!res.isValid())
        //     return ResponseEntity.badRequest().body(res.getResponse());

        // ValidTransactionRequest authRequest = new ValidTransactionRequest(auth.getMessageId(),
        //         auth.getUserId(),
        //         new Balance(auth.getTransactAmount().getAmount(),
        //                 auth.getTransactAmount().getCurrency(),
        //                 auth.getTransactAmount().getDebitOrCredit()));

        // // Code to debit amount
        // User concernedUser = null; // user.getUser(authRequest.getUserId());

        // // User object check
        // if (concernedUser == null)
        //     return ResponseEntity.badRequest().body(new Responces().BadRequestNoUserFound());

        // // TODO: -----------------
        // if (debit.debitAmount(concernedUser, authRequest.getValidTransactAmount().getAmount())) {
        //     eventLogger.logTransactionEvent(authRequest.getUserId(), new Events("AUTHORIZATION",
        //             authRequest.getMessageId(),
        //             authRequest.getUserId(),
        //             authRequest.getValidTransactAmount().getDebitOrCredit(),
        //             authRequest.getValidTransactAmount().getAmount(),
        //             "APPROVED",
        //             concernedUser.getBalance().toString(),
        //             new Ping().getTimeStamp()));
        //     return ResponseEntity.ok().body(createResponse.approveAuthorizationMessage(auth, concernedUser));
        // } else {
        //     eventLogger.logTransactionEvent(authRequest.getUserId(), new Events("AUTHORIZATION",
        //             authRequest.getMessageId(),
        //             authRequest.getUserId(),
        //             authRequest.getValidTransactAmount().getDebitOrCredit(),
        //             authRequest.getValidTransactAmount().getAmount(),
        //             "DENIED",
        //             concernedUser.getBalance().toString(),
        //             new Ping().getTimeStamp()));

        //     eventLogger.fetchUserEvents(authRequest.getUserId());
            // return ResponseEntity.ok().body(createResponse.deniedAuthorizationMessage(auth, concernedUser));

        // }
        
        return null;
    }

    @PutMapping("/load")
    public ResponseEntity<JSONObject> load(@RequestBody TransactionRequest auth) {

        // BoolResponce res = responseBodyCheck.checkPayloadForLoad(auth, eventLogger);

        // if (!res.isValid())
        //     return ResponseEntity.badRequest().body(res.getResponse());

        // ValidTransactionRequest authRequest = new ValidTransactionRequest(auth.getMessageId(),
        //         auth.getUserId(),
        //         new Balance(auth.getTransactAmount().getAmount(),
        //                 auth.getTransactAmount().getCurrency(),
        //                 auth.getTransactAmount().getDebitOrCredit()));

        // // TODO: ----------------
        // User concernedUser = null; // user.getUser(authRequest.getUserId());

        // if (concernedUser == null)
        //     return ResponseEntity.badRequest().body(new Responces().BadRequestNoUserFound());

        // // TODO: ---------------
        // credit.creditAmount(concernedUser, authRequest.getValidTransactAmount().getAmount());

        // eventLogger.logTransactionEvent(authRequest.getUserId(), new Events("LOAD",
        //         authRequest.getMessageId(),
        //         authRequest.getUserId(),
        //         authRequest.getValidTransactAmount().getDebitOrCredit(),
        //         authRequest.getValidTransactAmount().getAmount(),
        //         "APPROVED",
        //         concernedUser.getBalance().toString(),
        //         new Ping().getTimeStamp()));

        // return ResponseEntity.ok().body(createResponse.approveLoadMessage(auth, concernedUser));

        return null;
    }

}
