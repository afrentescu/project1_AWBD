package com.project.project1.service;

import com.project.project1.model.Professor;
import com.project.project1.model.Student;

import java.util.List;

public interface ProfessorSevrice {

    List<Professor> findAll();
    Professor findProfessorById(int id);
    Professor addProfessor(Professor professor);
    List<Professor>  findByDepartment(int departmentId);
    void deleteById(int id);
}
