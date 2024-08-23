package com.example.atletikplanning.DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TimeSlotDTO {
    private Long id;
    private String label;
    private int startTime;
    private int endTime;
    private LocalDate date;

    public TimeSlotDTO(Long id, String label, int startTime, int endTime, LocalDate date) {
        this.id = id;
        this.label = label;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }
}