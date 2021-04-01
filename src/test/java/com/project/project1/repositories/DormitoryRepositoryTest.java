package com.project.project1.repositories;


import com.project.project1.model.Dormitory;
import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import com.project.project1.repository.DormitoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Slf4j
public class DormitoryRepositoryTest {

    @Autowired
    private DormitoryRepository dormitoryRepository;

    @Test
    public void addDormitory()
    {
        Dormitory dormitory = new Dormitory();
        dormitory.setAddress("dorm N05 address");
        dormitory.setCapacity(450);
        dormitory.setName("No5 South");
        dormitoryRepository.save(dormitory);}


    @Test
    public void findAllDormitories() {
        List<Dormitory> dormitories = (List<Dormitory>) dormitoryRepository.findAll();
        assertTrue(dormitories.size() >= 2);
        log.info("findAllDormitories ...");
        dormitories.forEach(dormitory -> log.info(String.valueOf(dormitory.getId())));
    }
/*
    @Test
    public void deleteDormitoryById() {
        dormitoryRepository.deleteById(5);
        assertThat(dormitoryRepository.count()), is("1");    }
*/

}
