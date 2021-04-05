package com.project.project1.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.project1.model.Department;
import com.project.project1.model.Dormitory;
import com.project.project1.service.DepartmentService;
import com.project.project1.service.DormitoryService;
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
public class DormitoryControllerTestIT {


    @Autowired
    MockMvc mockMvc;
    @MockBean
    DormitoryService dormitoryService;
    @MockBean
    Model model;

    private ObjectMapper objectMapper =  new ObjectMapper();



    @Test
    public void addDormitoryTest() throws  Exception{
        Dormitory dormitory = new Dormitory(100, "dormitory1" , "address23", 1000);
        when( dormitoryService.addDormitory(any())).thenReturn(dormitory);
        log.info("adding a test dormitory ...");
        mockMvc.perform(post("/dormitory/new")
                .contentType("application/json" ).content(objectMapper.writeValueAsString(dormitory)) )
                .andExpect(status().isOk());

    }

    @Test
    public void showAddPage() throws Exception {
        log.info("checking returned view for adding a dormitory...");
        mockMvc.perform(post("/dormitory/new/", "1")).andExpect(status().isOk()).andExpect(view().name("dormitoryAdd"));
    }

    @Test
    public void showAll() throws Exception {
        mockMvc.perform(get("/dormitories/list", "1")).andExpect(status().isOk()).andExpect(view().name("dormitories"));
    }
}
