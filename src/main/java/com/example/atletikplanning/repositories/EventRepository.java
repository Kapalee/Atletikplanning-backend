package com.example.atletikplanning.repositories;

import com.example.atletikplanning.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.track.id = :trackId AND e.timeSlot.date = :date " +
            "AND ((:startTime BETWEEN e.timeSlot.startTime AND e.timeSlot.endTime) OR " +
            "(:endTime BETWEEN e.timeSlot.startTime AND e.timeSlot.endTime) OR " +
            "(e.timeSlot.startTime BETWEEN :startTime AND :endTime))")
    List<Event> findConflictingEvents(@Param("trackId") Long trackId,
                                      @Param("startTime") int startTime,
                                      @Param("endTime") int endTime,
                                      @Param("date") LocalDate date);

    @Query("SELECT e FROM Event e WHERE e.discipline.id = :disciplineId AND e.participantAgeGroup = :participantAgeGroup AND e.participantsGender = :participantsGender")
    List<Event> findSimilarEvents(@Param("disciplineId") Long disciplineId,
                                  @Param("participantAgeGroup") String participantAgeGroup,
                                  @Param("participantsGender") String participantsGender);

}
