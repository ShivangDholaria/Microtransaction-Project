package dev.transacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.transacts.entity.Events;

public interface EventRepository extends JpaRepository<Events, String>{
    
}
