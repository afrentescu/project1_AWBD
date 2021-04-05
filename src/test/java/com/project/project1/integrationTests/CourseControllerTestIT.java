package com.project.project1.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.project1.model.Course;
import com.project.project1.service.CourseService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class CourseControllerTestIT {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    CourseService courseService;
    @MockBean
    Model model;

    private ObjectMapper objectMapper =  new ObjectMapper();

    @Test
    public void showByIdMvc() throws Exception {
        log.info("checking returned view & course info ...");
        mockMvc.perform(get("/course/info/{id}", "1")).andExpect(status().isOk()).andExpect(view().name("courseInfo"));
    }


    @Test
    public void addCourseTest() throws  Exception{
        Course course = new Course(90, "name", "description" );
        when( courseService.addCourse(any())).thenReturn(course);
        log.info("adding test course ...");
        mockMvc.perform(post("/course/new")
                .contentType("application/json" ).content(objectMapper.writeValueAsString(course)) )
                .andExpect(status().isOk());

    }
/*
    @Test
    public void deleteCourseTest()  throws  Exception{
        Course course = new Course(90, "name", "description" );
        when(courseService.deleteById(anyInt())).thenReturn(course.getId());

        mockMvc.perform(delete("/course/delete/{id}").param("id", "90")
                .contentType("application/json").content(objectMapper.writeValueAsString(course)))
                .andExpect(status().isOk());
    }
*/

    @Test
    public void checkNotFoundStatus() throws Exception {
        mockMvc.perform(get("/course/info/{id}","200")).andExpect(status().isNotFound());//.andExpect(view().name("notfound"));
    }


    @Test
    public void showAddPage() throws Exception {
        log.info("checking returned view for adding a course ...");
        mockMvc.perform(post("/course/new/", "1")).andExpect(status().isOk()).andExpect(view().name("courseAdd"));
    }

    @Test
    public void showAll() throws Exception {
        log.info("checking returned view for data retrieve (course) ...");
        mockMvc.perform(get("/courses/list", "1")).andExpect(status().isOk()).andExpect(view().name("courses"));
    }
}
