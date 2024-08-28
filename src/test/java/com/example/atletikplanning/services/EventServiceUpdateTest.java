package com.example.atletikplanning.services;

import com.example.atletikplanning.entities.Discipline;
import com.example.atletikplanning.entities.Event;
import com.example.atletikplanning.entities.Track;
import com.example.atletikplanning.repositories.DisciplineRepository;
import com.example.atletikplanning.repositories.EventRepository;
import com.example.atletikplanning.repositories.TrackRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EventServiceUpdateTest {

    @InjectMocks
    private EventService eventService;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private DisciplineRepository disciplineRepository;

    @Mock
    private TrackRepository trackRepository;

    private Event existingEvent;
    private Discipline discipline;
    private Track track;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Setup existing event
        discipline = new Discipline();
        discipline.setId(1L);

        track = new Track();
        track.setId(2L);
        track.setDiscipline(discipline);

        existingEvent = new Event();
        existingEvent.setId(1L);
        existingEvent.setDiscipline(discipline);
        existingEvent.setTrack(track);
    }

    @Test
    public void testUpdateEvent_Success() {
        // Arrange
        when(eventRepository.findById(1L)).thenReturn(Optional.of(existingEvent));
        when(disciplineRepository.findById(1L)).thenReturn(Optional.of(discipline));
        when(trackRepository.findById(2L)).thenReturn(Optional.of(track));

        Event updatedEvent = new Event();
        updatedEvent.setMinimumDuration(30);
        updatedEvent.setDiscipline(discipline);
        updatedEvent.setTrack(track);
        updatedEvent.setMaximumParticipants(100);
        updatedEvent.setParticipantAgeGroup("18-25");
        updatedEvent.setParticipantsGender("Male");

        // Act
        eventService.updateEvent(1L, updatedEvent);

        // Assert
        assertEquals(30, existingEvent.getMinimumDuration());
        assertEquals(discipline, existingEvent.getDiscipline());
        assertEquals(track, existingEvent.getTrack());
        assertEquals(100, existingEvent.getMaximumParticipants());
        verify(eventRepository).save(existingEvent);
    }

    @Test
    public void testUpdateEvent_TrackDisciplineMismatch() {
        // Arrange
        when(eventRepository.findById(1L)).thenReturn(Optional.of(existingEvent));
        when(disciplineRepository.findById(2L)).thenReturn(Optional.of(new Discipline())); // Different discipline
        when(trackRepository.findById(2L)).thenReturn(Optional.of(track));

        Event updatedEvent = new Event();
        updatedEvent.setDiscipline(new Discipline()); // Different discipline
        updatedEvent.setTrack(track);

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            eventService.updateEvent(1L, updatedEvent);
        });

        assertEquals("The selected track is not suitable for the discipline.", exception.getMessage());
    }
}