package com.project.project1.repositories;
import java.util.List;

import com.project.project1.model.Department;
import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import com.project.project1.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.slf4j.Logger;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Slf4j
public class ProfessorRepositoryTest {

    @Autowired
    ProfessorRepository professorRepository;


    @Test
    public void addProfessor()
    {
        Professor professor = new Professor();
       professor.setFirstName("Magda");
       professor.setLastName("Popa");
       professor.setEmail(" aaassaaa");
        professorRepository.save(professor);}


    @Test
    public void findByLastName() {

         // final Logger logger = LoggerFactory.getLogger(ProfessorRepositoryTest.class);

        List<Professor> professors = professorRepository.findByLastName("Evan");
        assertFalse(professors.isEmpty());
        log.info("findByLastName ...");
        professors.forEach(professor -> log.info(professor.getLastName()));}


    @Test
    public void findById() {

        Professor professors = professorRepository.findProfessorById(2);
        assertFalse(professors.equals(null));

    }

    @Test
    public void deleteById(){
        professorRepository.deleteById(6);
        assertThat(professorRepository.count()).isEqualTo(5);
    }

}
