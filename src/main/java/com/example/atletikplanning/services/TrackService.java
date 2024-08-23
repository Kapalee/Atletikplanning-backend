package com.example.atletikplanning.services;


import com.example.atletikplanning.entities.Track;
import com.example.atletikplanning.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public List<Track> getTracksByDiscipline(Long disciplineId) {
        return trackRepository.findByDisciplineId(disciplineId);
    }
}

