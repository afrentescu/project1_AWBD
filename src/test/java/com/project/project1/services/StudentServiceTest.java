package com.project.project1.services;

import com.project.project1.model.Student;
import com.project.project1.repository.StudentRepository;
import com.project.project1.service.StudentService;
import com.project.project1.service.StudentServiceImplement;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        studentService = new StudentServiceImplement(studentRepository);
    }
    @Test
    public void findAllStudents() {
        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
    student.setId(1);
    student.setFirstName("test");
    student.setLastName("lastTest");
    students.add(student);
    when(studentRepository.findAll()).thenReturn(students);
    List<Student> allStudents = studentService.findAll();
    assertEquals(allStudents.size(), 1);
    verify(studentRepository, times(1)).findAll();}
}
