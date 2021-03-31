package com.project.project1.repository;
import java.util.List;

import com.project.project1.model.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

    List<Professor> findByLastName(String lastName);
    Professor findById( int id);
}
