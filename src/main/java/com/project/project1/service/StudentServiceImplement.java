package com.project.project1.service;


import com.project.project1.model.Course;
import com.project.project1.model.Student;
import com.project.project1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImplement implements  StudentService{

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplement(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new LinkedList<>();
        studentRepository.findAll().iterator().forEachRemaining(students::add);
        return students;    }

    @Override
    public Student findStudentById(int id) {
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findStudentById(id));
        if (!studentOptional.isPresent())
        {
            throw new RuntimeException("Student not found!");
        }
        return studentOptional.get();
    }

    @Override
    public Student addStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    @Override
    public void deleteById(int id) {

        Optional<Student> studentOptional = studentRepository.findById(id);
        if (!studentOptional.isPresent()) {
            throw new RuntimeException("Student not found!");
        }
        Student student= studentOptional.get();
        List<Course> courses = new LinkedList<Course>();
        student.getCourses().iterator().forEachRemaining(courses::add);

        for (Course course: courses
        ) {
            student.removeCourse(course);
        }

        studentRepository.save(student);
        studentRepository.deleteById(id);

    }

    @Override
    public List<Student> findByDepartment(int departmentId) {
        List<Student> students = studentRepository.findByDepartment(departmentId);
        if (students.isEmpty())
        {
            throw new RuntimeException("there are no students in the specified department!");
        }
        return students;
    }

    @Override
    public List<Student> findByDormitory(int id) {
        List<Student> students = studentRepository.findByDormitory(id);
        if (students.isEmpty())
        {
            throw new RuntimeException("there are no students in the specified dormitory!");
        }
        return students;
    }
}
