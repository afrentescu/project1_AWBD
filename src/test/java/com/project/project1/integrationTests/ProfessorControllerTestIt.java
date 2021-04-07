package com.project.project1.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.project1.model.Dormitory;
import com.project.project1.model.Professor;
import com.project.project1.service.DormitoryService;
import com.project.project1.service.ProfessorSevrice;
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
public class ProfessorControllerTestIt {


    @Autowired
    MockMvc mockMvc;
    @MockBean
    ProfessorSevrice professorSevrice;
    @MockBean
    Model model;

    private ObjectMapper objectMapper =  new ObjectMapper();



    @Test
    public void addProfessorTest() throws  Exception{
        Professor professor = new Professor(100, "Prof" , "Lastname", "email");
        when( professorSevrice.addProfessor(any())).thenReturn(professor);
        log.info("adding test professor ...");
        mockMvc.perform(post("/professor/new")
                .contentType("application/json" ).content(objectMapper.writeValueAsString(professor)) )
                .andExpect(status().isForbidden());

    }

    @Test
    public void showAddPage() throws Exception {
        log.info("checking returned viewfor adding a professor ...");
        mockMvc.perform(post("/professor/new/", "1")).andExpect(status().isOk()).andExpect(view().name("profAdd"));
    }

    @Test
    public void showAll() throws Exception {
        log.info("checking returned view for retrieveing professors ...");
        mockMvc.perform(get("/professors/list", "1")).andExpect(status().isOk()).andExpect(view().name("professors"));
    }
}
