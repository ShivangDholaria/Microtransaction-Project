package resources.UnitTests.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dev.transacts.entity.Events;
import dev.transacts.service.EventLogger;

public class EventLoggerTest {

    private EventLogger eventLogger;

    @Before
    public void setUp() {
        eventLogger = EventLogger.getInstance();
    }

    @Test
    public void testMessageIDExists() {
        Events event = new Events();
        event.setMessageID("1234");
        eventLogger.logTransactionEvent("user1", event);

        assertTrue(eventLogger.messageIDExists(event.getMessageID()));
    }

    @Test
    public void testMessageIDDoesNotExist() {
        assertFalse(eventLogger.messageIDExists("nonexistentId"));
    }
}