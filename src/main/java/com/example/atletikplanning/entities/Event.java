package com.example.atletikplanning.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int minimumDuration;
    private String participantsGender;
    private String participantAgeGroup;
    private int maximumParticipants;

    @ManyToOne
    @JsonBackReference("discipline-events")
    private Discipline discipline;

    @ManyToOne
    @JsonBackReference("timeSlot-events")
    private TimeSlot timeSlot;

    @ManyToOne
    @JsonBackReference("track-events")
    private Track track;



    public Event(int minimumDuration, String participantsGender, String participantAgeGroup, int maximumParticipants) {
        this.minimumDuration = minimumDuration;
        this.participantsGender = participantsGender;
        this.participantAgeGroup = participantAgeGroup;
        this.maximumParticipants = maximumParticipants;
    }
}
