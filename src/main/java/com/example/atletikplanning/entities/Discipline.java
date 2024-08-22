package com.example.atletikplanning.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "discipline")
    @JsonManagedReference("discipline-events")
    private List<Event> events;

    @OneToMany(mappedBy = "discipline")
    @JsonManagedReference("discipline-tracks")
    private List<Track> tracks;



    private String name;
    private int approxDuration;

    public Discipline(String name, int approxDuration) {
        this.name = name;
        this.approxDuration = approxDuration;
    }
}
