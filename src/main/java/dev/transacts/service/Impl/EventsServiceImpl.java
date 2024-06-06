package dev.transacts.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.transacts.entity.Events;
import dev.transacts.repository.EventRepository;
import dev.transacts.service.EventsService;

@Service
public class EventsServiceImpl implements EventsService{

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
    
}
