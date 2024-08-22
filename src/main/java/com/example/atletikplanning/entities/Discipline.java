package com.example.atletikplanning.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "discipline")
    private List<Event> events;

    @JsonIgnore
    @OneToMany(mappedBy = "discipline")
    private List<Track> tracks;



    private String name;
    private int approxDuration;

    public Discipline(String name, int approxDuration) {
        this.name = name;
        this.approxDuration = approxDuration;
    }
}
