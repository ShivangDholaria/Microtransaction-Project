package dev.transacts.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.transacts.entity.Events;
import dev.transacts.repository.EventRepository;
import dev.transacts.service.EventsService;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventRepository eventsRepository;

    @Override
    public Events saveEvent(Events event) {
        return eventsRepository.save(event);
    }

	@Override
	public boolean isExist(String eventID) {
        return eventsRepository.existsById(eventID);
    }

    @Override
    public List<Events> getAllEvents() {
        return (List<Events>)eventsRepository.findAll();
    }

    @Override
    public List<Events> getUserEvents(String eventID) {
        return eventsRepository.findEventsbyUserId(eventID);
    }
        
    
}
