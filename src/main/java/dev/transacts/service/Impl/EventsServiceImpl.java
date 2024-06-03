package dev.transacts.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.transacts.entity.Events;
import dev.transacts.repository.EventRepository;
import dev.transacts.service.EventsService;

public class EventsServiceImpl implements EventsService{

    @Autowired
    private EventRepository eventsRepository;

    @Override
    public Events saveEvents(Events events) {
        return eventsRepository.save(events);
    }

	@Override
	public List<Events> fetchEvents(String eventID) {
        //TODO:
        //  -- Implement the fetchEvents method

        return null;
    }
    
}
