package dev.transacts.service;

import dev.transacts.entity.Events;

public interface EventsService {

    //Save operation
    Events saveEvent(Events events);
    
    //Get operation
    boolean isExist(String eventID);

}