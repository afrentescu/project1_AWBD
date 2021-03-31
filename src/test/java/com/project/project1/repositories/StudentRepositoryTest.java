package com.project.project1.repositories;

import com.project.project1.model.Student;
import com.project.project1.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")@Rollback(false)

public class StudentRepositoryTest
{
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void addStudent()
    {
        Student student = new Student();
        student.setFirstName("Adela");
        student.setLastName("Frentescu");
        student.setEmail("adelafrentescu@gmail.com");
        studentRepository.save(student);}

}