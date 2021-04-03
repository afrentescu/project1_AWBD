package com.project.project1.repository;
import java.util.List;

import com.project.project1.model.Department;
import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

    List<Professor> findByLastName(String lastName);

    @Query("select p from Professor p where p.professorDep.id = ?1")
    List<Professor>  findByDepartment(int departmentId);

    Professor findById( int id);
    void deleteById(int id);
}
