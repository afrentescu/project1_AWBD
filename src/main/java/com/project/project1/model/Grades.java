package com.project.project1.model;


import javax.persistence.*;

@Entity
public class Grades {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int grade;


    @OneToOne
    private Exam exam;

    @ManyToOne
    private Student studentGrade;

    public Grades(){}





}
