package com.example.atletikplanning.repositories;

import com.example.atletikplanning.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
