package com.example.atletikplanning.repositories;

import com.example.atletikplanning.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
