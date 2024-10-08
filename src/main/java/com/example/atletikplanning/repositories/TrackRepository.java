package com.example.atletikplanning.repositories;

import com.example.atletikplanning.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findByDisciplineId(Long disciplineId);
}
