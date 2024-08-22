package com.example.atletikplanning.services;


import com.example.atletikplanning.entities.Discipline;
import com.example.atletikplanning.repositories.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public Discipline create(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }



}
