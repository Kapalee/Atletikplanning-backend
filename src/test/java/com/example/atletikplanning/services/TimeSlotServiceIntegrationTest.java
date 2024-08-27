package com.example.atletikplanning.services;

import com.example.atletikplanning.DTO.TimeSlotDTO;
import com.example.atletikplanning.entities.TimeSlot;
import com.example.atletikplanning.repositories.TimeSlotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test") // Use the test profile
@AutoConfigureMockMvc
public class TimeSlotServiceIntegrationTest {

    @Autowired
    private TimeSlotService timeSlotService;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @BeforeEach
    public void setUp() {
        // Clear the repository before each test
        timeSlotRepository.deleteAll();
    }

    @Test
    public void testGetAllTimeSlots() {
        // Arrange: Create and save a time slot
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setStartTime(900);
        timeSlot.setEndTime(1000);
        timeSlot.setDate(LocalDate.of(2024, 9, 1));
        timeSlotRepository.save(timeSlot);

        // Act: Retrieve all time slots
        List<TimeSlotDTO> timeSlots = timeSlotService.getAllTimeSlots();

        // Assert: Check that the retrieved time slots match the saved time slot
        assertThat(timeSlots).hasSize(1);
        assertThat(timeSlots.get(0).getStartTime()).isEqualTo(900);
        assertThat(timeSlots.get(0).getEndTime()).isEqualTo(1000);
        assertThat(timeSlots.get(0).getDate()).isEqualTo(LocalDate.of(2024, 9, 1));
    }

    @Test
    public void testCreateTimeSlot() {
        // Arrange: Create a new time slot
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setStartTime(1100);
        timeSlot.setEndTime(1200);
        timeSlot.setDate(LocalDate.of(2024, 9, 1));

        // Act: Create the time slot using the service
        TimeSlot createdTimeSlot = timeSlotService.create(timeSlot);

        // Assert: Check that the time slot was created successfully
        assertThat(createdTimeSlot).isNotNull();
        assertThat(createdTimeSlot.getId()).isNotNull(); // ID should be generated
        assertThat(createdTimeSlot.getStartTime()).isEqualTo(1100);
        assertThat(createdTimeSlot.getEndTime()).isEqualTo(1200);
        assertThat(createdTimeSlot.getDate()).isEqualTo(LocalDate.of(2024, 9, 1));
    }
}