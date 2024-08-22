package com.example.atletikplanning.repositories;

import com.example.atletikplanning.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
