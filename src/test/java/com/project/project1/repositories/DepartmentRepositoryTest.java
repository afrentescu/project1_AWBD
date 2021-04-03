package com.project.project1.repositories;


import com.project.project1.model.Department;
import com.project.project1.model.Dormitory;
import com.project.project1.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Slf4j
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Test
    public void addDepartment()
    {
        Department department = new Department();
        department.setName("Medicine");
        departmentRepository.save(department);}


    @Test
    public void findAllDepartments() {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        assertTrue(departments.size() >= 5);
        log.info("findAllDepartments ...");
        departments.forEach(department -> log.info(String.valueOf(department.getId())));
    }


}
