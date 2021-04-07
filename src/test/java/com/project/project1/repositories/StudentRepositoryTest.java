package com.project.project1.repositories;
import com.project.project1.model.Student;
import com.project.project1.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")@Rollback(false)
@Slf4j
public class StudentRepositoryTest
{
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void addStudent()
    {
        Student student = new Student();
        student.setFirstName("Adena");
        student.setLastName("Frentescu");
        student.setEmail("adelafrentescu@gmail.com");
        studentRepository.save(student);}


    @Test
    public void findStudentsByDepartment() {
        List<Student> students = studentRepository.findByDepartment(1);
        assertTrue(students.size() >= 2);
        log.info("findByDepartment ...");
        students.forEach(student -> log.info(String.valueOf(student.getStudentDep().getId())));
    }

    @Test
    public void findStudentsByDormitory() {
        List<Student> students = studentRepository.findByDormitory(3);
        assertTrue(students.size() >= 2);
        log.info("findByDormitory ...");
        students.forEach(student -> log.info(String.valueOf(student.getStudDormitory().getId())));
    }

    @Test
    public void findPage(){
        PageRequest firstPage = PageRequest.of(0, 2);
        Page<Student> allStudents = studentRepository.findAll(firstPage);
    Assert.assertTrue(allStudents.getNumberOfElements() == 2);}

    @Test
    public void deleteById(){
        studentRepository.deleteById(1006);
        assertThat(studentRepository.count()).isEqualTo(11);
    }
}