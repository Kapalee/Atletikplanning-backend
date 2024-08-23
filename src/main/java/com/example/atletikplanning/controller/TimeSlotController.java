package com.example.atletikplanning.controller;


import com.example.atletikplanning.DTO.TimeSlotDTO;
import com.example.atletikplanning.entities.TimeSlot;
import com.example.atletikplanning.services.TimeSlotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }


    @GetMapping
    public List<TimeSlotDTO> getTimeSlots() {
        return timeSlotService.getAllTimeSlots();
    }


    @PostMapping
    public TimeSlot createTimeslot(@RequestBody TimeSlot timeSlot) {
        return timeSlotService.create(timeSlot);
    }
}
