package com.example.atletikplanning.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "timeSlot")
    private List<Event> events;

    private int startTime;
    private int endTime;
    private LocalDate date;

    public String getFormattedTimeSlot() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // 24-hour format
        LocalTime start = LocalTime.of(startTime / 100, startTime % 100);
        LocalTime end = LocalTime.of(endTime / 100, endTime % 100);
        return start.format(formatter) + " - " + end.format(formatter);
    }
}
