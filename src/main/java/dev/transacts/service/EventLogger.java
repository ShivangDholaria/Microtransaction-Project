package dev.transacts.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dev.transacts.entity.Events;

/**
 * The EventLogger class is responsible for logging transaction events and retrieving user events.
 */
public class EventLogger {

    private static EventLogger instance;
    
    // User-wise event logging
    Map<String, List<Events>> transactionEventLogger;
     
    Set<String> messageIDSet;
    
    /**
     * Constructs a new EventLogger object.
     * Initializes the transactionEventLogger and messageIDSet.
     */
    EventLogger() {
        transactionEventLogger = new HashMap<>();
        messageIDSet = new HashSet<>();
    }

    /**
     * Checks if a message ID already exists in the messageIDSet.
     * @param messageId The message ID to check.
     * @return true if the message ID exists, false otherwise.
     */
    public boolean messageIDExists(String messageId) {
        if(messageIDSet.contains(messageId))
            return true;
        return false;
    }

    /**
     * Logs a transaction event for a specific user.
     * Adds the event to the user's list of events in the transactionEventLogger.
     * @param userId The ID of the user.
     * @param events The event to log.
     */
    public void logTransactionEvent(String userId, Events events) {
        messageIDSet.add(events.getMessageID());
        List<Events> userEvents = transactionEventLogger.getOrDefault(userId, new ArrayList<>());
        userEvents.add(events);
        transactionEventLogger.put(userId, userEvents);
    }

    /**
     * Fetches and prints all events for a specific user.
     * @param userId The ID of the user.
     */
    public void fetchUserEvents(String userId) {
        List<Events> userEvents = transactionEventLogger.get(userId);
        if (userEvents != null) {
            for (Events event : userEvents) {
                System.out.println(event.toString());
            }
        }
    }
}
