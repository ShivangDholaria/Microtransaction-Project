package dev.transacts.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.transacts.entity.Events;
import dev.transacts.service.Impl.EventsServiceImpl;

public class EventLogger {

    // User-wise event logging
    public Map<String, List<Events>> transactionEventLogger;
         
    /**
     * Constructs a new EventLogger object.
     * Initializes the transactionEventLogger and messageIDSet.
     */
    public EventLogger() {
        transactionEventLogger = new HashMap<>();
    }

    /**
     * Logs a transaction event for a specific user.
     * Adds the event to the user's list of events in the transactionEventLogger.
     * @param userId The ID of the user.
     * @param events The event to log.
     */
    public void logTransactionEvent(String userId, Events events, EventsServiceImpl eServiceImpl) {
        List<Events> userEvents = transactionEventLogger.get(userId);
        userEvents.add(events);
        transactionEventLogger.put(userId, userEvents);
        eServiceImpl.saveEvent(events);
    }

}
