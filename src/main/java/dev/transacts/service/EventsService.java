package dev.transacts.service;

import java.util.List;

import dev.transacts.entity.Events;

public interface EventsService {

    //Save operation
    Events saveEvent(Events events);
    
    //Get operation
    boolean isExist(String eventID);

    //Get all Events
    List<Events> getAllEvents();

    //Get specific event
    List<Events> getUserEvents(String eventID);

}