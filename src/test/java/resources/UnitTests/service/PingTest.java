package resources.UnitTests.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dev.transacts.model.Ping;


public class PingTest {

    @Test
    public void testGetTimeStamp() {
        Ping ping = new Ping();
        ping.setTimeStamp("2022-01-01T00:00:00");
        assertEquals("2022-01-01T00:00:00", ping.getTimeStamp());
    }

}