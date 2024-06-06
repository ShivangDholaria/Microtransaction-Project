package dev.transacts.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import dev.transacts.entity.Events;
import dev.transacts.service.Impl.EventsServiceImpl;

public class EventLogger {

    @Autowired
    private EventsServiceImpl eServiceImpl;

    // User-wise event logging
    Map<String, List<Events>> transactionEventLogger;
         
    /**
     * Constructs a new EventLogger object.
     * Initializes the transactionEventLogger and messageIDSet.
     */
    EventLogger() {
        transactionEventLogger = new HashMap<>();
    }

    /**
     * Logs a transaction event for a specific user.
     * Adds the event to the user's list of events in the transactionEventLogger.
     * @param userId The ID of the user.
     * @param events The event to log.
     */
    public void logTransactionEvent(String userId, Events events) {
        List<Events> userEvents = transactionEventLogger.getOrDefault(userId, new ArrayList<>());
        userEvents.add(events);
        transactionEventLogger.put(userId, userEvents);
        eServiceImpl.saveEvent(events);
    }

}
