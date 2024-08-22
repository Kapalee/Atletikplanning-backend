package com.example.atletikplanning.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int minimumDuration;
    private String participantsGender;
    private int participantAgeGroup;
    private int maximumParticipants;

    @ManyToOne
    private Discipline discipline;

    @ManyToOne
    private TimeSlot timeSlot;

    @ManyToOne
    private Track track;



    public Event(int minimumDuration, String participantsGender, int participantAgeGroup, int maximumParticipants) {
        this.minimumDuration = minimumDuration;
        this.participantsGender = participantsGender;
        this.participantAgeGroup = participantAgeGroup;
        this.maximumParticipants = maximumParticipants;
    }
}
