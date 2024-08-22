package com.example.atletikplanning.services;

import com.example.atletikplanning.entities.Discipline;
import com.example.atletikplanning.entities.Event;
import com.example.atletikplanning.entities.TimeSlot;
import com.example.atletikplanning.entities.Track;
import com.example.atletikplanning.repositories.DisciplineRepository;
import com.example.atletikplanning.repositories.EventRepository;
import com.example.atletikplanning.repositories.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final TrackRepository trackRepository;
    private final DisciplineRepository disciplineRepository;

    public EventService(EventRepository eventRepository, TrackRepository trackRepository, DisciplineRepository disciplineRepository) {
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

    @Transactional
   public Event createEvent(Event event) {
        Track track = trackRepository.findById(event.getTrack().getId())
                .orElseThrow(() -> new IllegalArgumentException("Track not found"));
        Discipline discipline = track.getDiscipline();
        if (discipline == null || !discipline.getId().equals(event.getDiscipline().getId())) {
            throw new IllegalArgumentException("The selected track is not suitable for the discipline.");
        }
        validateTimeSlotAvailability(track, event.getTimeSlot());
        event.setTrack(track);
        event.setDiscipline(discipline);
        return eventRepository.save(event);
    }

    // Validation method to ensure the track is suitable for the discipline
    private void validateTrackAndDiscipline(Track track, Discipline discipline) {
        if (!track.getDiscipline().getId().equals(discipline.getId())) {
            throw new IllegalArgumentException("The selected track is not suitable for the discipline.");
        }
    }

    // Validation method to ensure the track is available during the desired time slot
    private void validateTimeSlotAvailability(Track track, TimeSlot timeSlot) {
        List<Event> conflictingEvents = eventRepository.findConflictingEvents(track.getId(), timeSlot.getStartTime(), timeSlot.getEndTime(), timeSlot.getDate());
        if (!conflictingEvents.isEmpty()) {
            throw new IllegalArgumentException("The selected time slot overlaps with another event on the same track.");
        }
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
