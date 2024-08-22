package com.example.atletikplanning.entities;


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
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "track")
    private List<Event> events;

    @ManyToOne
    private Discipline discipline;

    private String type;
    private String shape;
    private String surface;
    private int length;
    private String lanes;
}
