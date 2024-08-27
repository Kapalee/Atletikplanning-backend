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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class EventServiceIntegrationTest {

    @Autowired
    private EventService eventService;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private EventRepository eventRepository;

    private Discipline discipline;
    private Track track;
    private TimeSlot timeSlot;


    @BeforeEach
    void setUp() {
        discipline = new Discipline("100m Sprint", 10);
        disciplineRepository.save(discipline);

        track = new Track();
        track.setDiscipline(discipline);
        track.setType("Track");
        track.setShape("Straight");
        track.setSurface("Synthetic");
        track.setLength(100);
        track.setLanes("6");
        trackRepository.save(track);

        timeSlot = new TimeSlot();
        timeSlot.setStartTime(900);
        timeSlot.setEndTime(1000);
        timeSlot.setDate(LocalDate.of(2024, 9, 1));
        timeSlotRepository.save(timeSlot);
    }

    @Test
    void testCreateEvent() {
        EventDto eventDto = new EventDto();
        eventDto.setDisciplineId(discipline.getId());
        eventDto.setTrackId(track.getId());
        eventDto.setTimeSlotId(timeSlot.getId());
        eventDto.setMinimumDuration(10);
        eventDto.setParticipantsGender("Male");
        eventDto.setParticipantAgeGroup("Adult");
        eventDto.setMaximumParticipants(10);

        Event createdEvent = eventService.createEventFromDto(eventDto);

        assertNotNull(createdEvent);
        assertEquals(discipline.getId(), createdEvent.getDiscipline().getId());
        assertEquals(track.getId(), createdEvent.getTrack().getId());
        assertEquals(timeSlot.getId(), createdEvent.getTimeSlot().getId());
    }

    @Test
    void testGetAllEvents() {
        EventDto eventDto = new EventDto();
        eventDto.setDisciplineId(discipline.getId());
        eventDto.setTrackId(track.getId());
        eventDto.setTimeSlotId(timeSlot.getId());
        eventDto.setMinimumDuration(10);
        eventDto.setParticipantsGender("Male");
        eventDto.setParticipantAgeGroup("Adult");
        eventDto.setMaximumParticipants(10);
        eventService.createEventFromDto(eventDto);

        List<Event> events = eventService.getAllEvents();
        assertFalse(events.isEmpty());
    }
}