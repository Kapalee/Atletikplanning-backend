package com.example.atletikplanning.controller;


import com.example.atletikplanning.entities.Track;
import com.example.atletikplanning.services.TrackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }




}
