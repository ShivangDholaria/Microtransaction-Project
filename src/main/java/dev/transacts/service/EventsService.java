package dev.transacts.service;

import java.util.List;

import dev.transacts.entity.Events;

public interface EventsService {

    //Save operation
    Events saveEvents(Events events);
    
    //Get operation
    List<Events> fetchEvents(String eventID);

}