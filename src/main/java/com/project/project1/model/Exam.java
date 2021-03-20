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

    @ManyToMany @JoinTable(name="exam_students", joinColumns = @JoinColumn ( name="exam_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
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

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", date=" + date +
                ", classromNr=" + classromNr +
                '}';
    }
}
