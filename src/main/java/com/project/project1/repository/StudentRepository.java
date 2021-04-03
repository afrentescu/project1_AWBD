package com.project.project1.repository;
import java.util.List;

import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {


    @Query("select s from Student s where s.studentDep.id = ?1")
   List<Student>  findByDepartment(int departmentId);

    @Query("select s from Student s where s.studDormitory.id = ?1")
    List<Student> findByDormitory(int id);


    Student findStudentById(int id);
    void deleteById(int id);
}
