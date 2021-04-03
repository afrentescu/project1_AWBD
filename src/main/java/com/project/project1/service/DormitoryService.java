package com.project.project1.service;

import com.project.project1.model.Dormitory;
import com.project.project1.model.Professor;
import com.project.project1.model.Student;

import java.util.List;

public interface DormitoryService {

    List<Dormitory> findAll();
    Dormitory findById(int id);
    Dormitory addDormitory(Dormitory dormitory);
}
