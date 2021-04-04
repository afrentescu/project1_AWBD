package com.project.project1.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Exam{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private int classromNr;

    @OneToOne
    private Course course;

    @OneToOne
    private Grades grade;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})@JoinTable( name="exam_students", joinColumns = @JoinColumn ( name="exam_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Student> examStudents;


    public Exam(){}


    public Exam(int id, LocalDateTime date, int classromNr) {
        this.id = id;
        this.date = date;
        this.classromNr = classromNr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getClassromNr() {
        return classromNr;
    }

    public void setClassromNr(int classromNr) {
        this.classromNr = classromNr;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Grades getGrade() {
        return grade;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }

    public List<Student> getExamStudents() {
        return examStudents;
    }

    public void setExamStudents(List<Student> examStudents) {
        this.examStudents = examStudents;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", date=" + date +
                ", classromNr=" + classromNr +
                '}';
    }

    public void removeStudent(Student student) {
        student.getExams().remove(this);
        examStudents.remove(student);
    }
}
