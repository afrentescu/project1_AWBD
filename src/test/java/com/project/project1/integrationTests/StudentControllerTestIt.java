package com.project.project1.integrationTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import com.project.project1.service.ProfessorSevrice;
import com.project.project1.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class StudentControllerTestIt {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    StudentService studentService;
    @MockBean
    Model model;

    private ObjectMapper objectMapper =  new ObjectMapper();



    @Test
    public void addStudentTest() throws  Exception{
        Student student = new Student(100, "Stud1" , "Lastname", "email");
        when( studentService.addStudent(any())).thenReturn(student);
        log.info("adding test student ...");
        mockMvc.perform(post("/student/new")
                .contentType("application/json" ).content(objectMapper.writeValueAsString(student)) )
                .andExpect(status().isForbidden());

    }

    @Test
    public void showAddPage() throws Exception {
        log.info("checking returned viewfor adding a student ...");
        mockMvc.perform(post("/student/new/", "1")).andExpect(status().isOk()).andExpect(view().name("studentAdd"));
    }

    @Test
    public void showAll() throws Exception {
        log.info("checking returned view for retrieving students ...");
        mockMvc.perform(get("/students/list", "1")).andExpect(status().isOk()).andExpect(view().name("students"));
    }
}
