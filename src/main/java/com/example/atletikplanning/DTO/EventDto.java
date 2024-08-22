package com.example.atletikplanning.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDto {
    private Long disciplineId;
    private Long trackId;
    private Long timeSlotId;
    private int minimumDuration;
    private String participantsGender;
    private String participantAgeGroup;
    private int maximumParticipants;
}