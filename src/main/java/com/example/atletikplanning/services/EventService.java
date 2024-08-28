package com.example.atletikplanning.services;

import com.example.atletikplanning.DTO.EventDto;
import com.example.atletikplanning.entities.Discipline;
import com.example.atletikplanning.entities.Event;
import com.example.atletikplanning.entities.TimeSlot;
import com.example.atletikplanning.entities.Track;
import com.example.atletikplanning.repositories.DisciplineRepository;
import com.example.atletikplanning.repositories.EventRepository;
import com.example.atletikplanning.repositories.TimeSlotRepository;
import com.example.atletikplanning.repositories.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final TrackRepository trackRepository;
    private final DisciplineRepository disciplineRepository;
    private final TimeSlotRepository timeSlotRepository;


    public EventService(EventRepository eventRepository, TrackRepository trackRepository, DisciplineRepository disciplineRepository, TimeSlotRepository timeSlotRepository) {
        this.eventRepository = eventRepository;
        this.trackRepository = trackRepository;
        this.disciplineRepository = disciplineRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Transactional
    public Event createEventFromDto(EventDto eventDto) {
        Discipline discipline = disciplineRepository.findById(eventDto.getDisciplineId())
                .orElseThrow(() -> new IllegalArgumentException("Discipline not found"));

        Track track = trackRepository.findById(eventDto.getTrackId())
                .orElseThrow(() -> new IllegalArgumentException("Track not found"));

        TimeSlot timeSlot = timeSlotRepository.findById(eventDto.getTimeSlotId())
                .orElseThrow(() -> new IllegalArgumentException("TimeSlot not found"));

        // Validate that the selected track is suitable for the discipline
        if (!track.getDiscipline().getId().equals(discipline.getId())) {
            throw new IllegalArgumentException("The selected track is not suitable for the discipline.");
        }

        // Validate time slot availability
        List<Event> conflictingEvents = eventRepository.findConflictingEvents(
                track.getId(),
                timeSlot.getStartTime(),
                timeSlot.getEndTime(),
                timeSlot.getDate()
        );
        if (!conflictingEvents.isEmpty()) {
            throw new IllegalArgumentException("The selected track is already booked for the given time slot.");
        }

        // Validate that the same event is not scheduled in another time slot or track
        List<Event> similarEvents = eventRepository.findSimilarEvents(
                eventDto.getDisciplineId(),
                eventDto.getParticipantAgeGroup(),
                eventDto.getParticipantsGender()
        );
        if (!similarEvents.isEmpty()) {
            throw new IllegalArgumentException("An event with the same discipline, participant age group, and gender already exists.");
        }

        Event event = new Event(
                eventDto.getMinimumDuration(),
                eventDto.getParticipantsGender(),
                eventDto.getParticipantAgeGroup(),
                eventDto.getMaximumParticipants()
        );

        event.setDiscipline(discipline);
        event.setTrack(track);
        event.setTimeSlot(timeSlot);

        return eventRepository.save(event);
    }


    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }




    public void updateEvent(Long id, Event event) {
        Event eventToUpdate = eventRepository.findById(id).orElse(null);
        if (eventToUpdate != null) {
            // Fetch discipline and track to validate
            Discipline discipline = disciplineRepository.findById(event.getDiscipline().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Discipline not found"));
            Track track = trackRepository.findById(event.getTrack().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Track not found"));

            // Validate that the selected track is suitable for the discipline
            if (!track.getDiscipline().getId().equals(discipline.getId())) {
                throw new IllegalArgumentException("The selected track is not suitable for the discipline.");
            }

            // Proceed with the update
            eventToUpdate.setMinimumDuration(event.getMinimumDuration());
            eventToUpdate.setDiscipline(discipline);
            eventToUpdate.setMaximumParticipants(event.getMaximumParticipants());
            eventToUpdate.setTrack(track);
            eventToUpdate.setParticipantAgeGroup(event.getParticipantAgeGroup());
            eventToUpdate.setParticipantsGender(event.getParticipantsGender());
            eventToUpdate.setTimeSlot(event.getTimeSlot());
            eventRepository.save(eventToUpdate);
        }
    }





}
