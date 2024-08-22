package com.example.atletikplanning.controller;

import com.example.atletikplanning.DTO.EventDto;
import com.example.atletikplanning.entities.Discipline;
import com.example.atletikplanning.entities.Event;
import com.example.atletikplanning.entities.TimeSlot;
import com.example.atletikplanning.entities.Track;
import com.example.atletikplanning.services.EventService;
import com.example.atletikplanning.services.DisciplineService;
import com.example.atletikplanning.services.TrackService;
import com.example.atletikplanning.services.TimeSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;
    private final DisciplineService disciplineService;
    private final TrackService trackService;
    private final TimeSlotService timeSlotService;

    public EventController(EventService eventService, DisciplineService disciplineService, TrackService trackService, TimeSlotService timeSlotService) {
        this.eventService = eventService;
        this.disciplineService = disciplineService;
        this.trackService = trackService;
        this.timeSlotService = timeSlotService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventDto eventDto) {
        try {
            Discipline discipline = disciplineService.findById(eventDto.getDisciplineId());
            Track track = trackService.findById(eventDto.getTrackId());
            TimeSlot timeSlot = timeSlotService.findById(eventDto.getTimeSlotId());

            Event event = new Event(
                    eventDto.getMinimumDuration(),
                    eventDto.getParticipantsGender(),
                    eventDto.getParticipantAgeGroup(),
                    eventDto.getMaximumParticipants()
            );

            event.setDiscipline(discipline);
            event.setTrack(track);
            event.setTimeSlot(timeSlot);

            Event createdEvent = eventService.create(event);
            return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public void updateEvent(@PathVariable Long id, @RequestBody Event event) {
        eventService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
    }
}