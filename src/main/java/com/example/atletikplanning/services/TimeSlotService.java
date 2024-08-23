package com.example.atletikplanning.services;

import com.example.atletikplanning.DTO.TimeSlotDTO;
import com.example.atletikplanning.entities.TimeSlot;
import com.example.atletikplanning.repositories.TimeSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    public List<TimeSlotDTO> getAllTimeSlots() {
        List<TimeSlot> timeSlots = timeSlotRepository.findAll();
        return timeSlots.stream()
                .map(ts -> new TimeSlotDTO(ts.getId(), ts.getFormattedTimeSlot(), ts.getStartTime(), ts.getEndTime(), ts.getDate()))
                .collect(Collectors.toList());
    }

    public TimeSlot create(TimeSlot timeSlot) {
        return timeSlotRepository.save(timeSlot);
    }
}