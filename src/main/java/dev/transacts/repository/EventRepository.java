package dev.transacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.transacts.entity.Events;

@Repository
public interface EventRepository extends JpaRepository<Events, String>{

    @Query("SELECT e FROM Events e WHERE e.userID LIKE :userId")
    List<Events> findEventsbyUserId(@Param("userId") String userId);
    
}
