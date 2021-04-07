package com.project.project1.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.project1.model.Course;
import com.project.project1.model.Department;
import com.project.project1.service.CourseService;
import com.project.project1.service.DepartmentService;
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
public class DepartmentControllerTestIT {


    @Autowired
    MockMvc mockMvc;
    @MockBean
    DepartmentService departmentService;
    @MockBean
    Model model;

    private ObjectMapper objectMapper =  new ObjectMapper();



    @Test
    public void addDepartmentTest() throws  Exception{
        Department department = new Department(100, "depTest" );
        when( departmentService.addDepartment(any())).thenReturn(department);

        mockMvc.perform(post("/department/new")
                .contentType("application/json" ).content(objectMapper.writeValueAsString(department)) )
                .andExpect(status().isForbidden());

    }

    @Test
    public void showAddPage() throws Exception {
        mockMvc.perform(post("/department/new/", "1")).andExpect(status().isForbidden()); //.andExpect(view().name("departmentAdd"));
    }

    @Test
    public void showAll() throws Exception {
        mockMvc.perform(get("/departments/list", "1")).andExpect(status().isOk()).andExpect(view().name("departments"));
    }
}
