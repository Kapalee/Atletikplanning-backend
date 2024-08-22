package com.example.atletikplanning.services;

import com.example.atletikplanning.entities.Event;
import com.example.atletikplanning.repositories.DisciplineRepository;
import com.example.atletikplanning.repositories.EventRepository;
import com.example.atletikplanning.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final TrackRepository trackRepository;
    private final DisciplineRepository disciplineRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.trackRepository = trackRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public Event createEvent(Event event) {
        validateTrackAndDiscipline(event.getTrack(), event.getDiscipline());
        validateTimeSlotAvailability(event.getTrack(), event.getTimeSlot());
        return eventRepository.save(event);
    }


    public void updateEvent(Long id, Event event) {
        Event eventToUpdate = eventRepository.findById(id).orElse(null);
        if (eventToUpdate != null) {
            eventToUpdate.setMinimumDuration(event.getMinimumDuration());
            eventToUpdate.setDiscipline(event.getDiscipline());
            eventToUpdate.setMaximumParticipants(event.getMaximumParticipants());
            eventToUpdate.setDiscipline(event.getDiscipline());
            eventToUpdate.setTrack(event.getTrack());
            eventToUpdate.setParticipantAgeGroup(event.getParticipantAgeGroup());
            eventRepository.save(eventToUpdate);
        }
    }





}
