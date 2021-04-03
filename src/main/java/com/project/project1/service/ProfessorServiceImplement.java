package com.project.project1.service;


import com.project.project1.model.Professor;
import com.project.project1.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class ProfessorServiceImplement implements  ProfessorSevrice{

    ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImplement(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> findAll() {
        List<Professor> professors = new LinkedList<>();
        professorRepository.findAll().iterator().forEachRemaining(professors::add);
        return professors;
    }

    @Override
    public Professor findProfessorById(int id) {
        Professor professor = professorRepository.findProfessorById(id);
        if (professor.equals(null))
        {
            throw new RuntimeException("Professor does not exist!");
        }
        return professor;
    }

    @Override
    public Professor addProfessor(Professor professor) {
        Professor savedProfessor = professorRepository.save(professor);
        return savedProfessor;
    }

    @Override
    public List<Professor> findByDepartment(int departmentId) {
        List<Professor> professors = professorRepository.findByDepartment(departmentId);
        if (professors.isEmpty())
        {
            throw new RuntimeException("there are no professors in the specified department!");
        }
        return professors;
    }

    @Override
    public void deleteById(int id) {
      professorRepository.deleteById(id);
    }
}
