package com.example.atletikplanning.services;

import com.example.atletikplanning.entities.TimeSlot;
import com.example.atletikplanning.repositories.TimeSlotRepository;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    public TimeSlot findById(Long id) {
        return timeSlotRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("TimeSlot not found"));
    }
}