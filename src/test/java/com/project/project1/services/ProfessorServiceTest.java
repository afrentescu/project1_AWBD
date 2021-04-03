package com.project.project1.services;

import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import com.project.project1.repository.ProfessorRepository;
import com.project.project1.repository.StudentRepository;
import com.project.project1.service.ProfessorServiceImplement;
import com.project.project1.service.ProfessorSevrice;
import com.project.project1.service.StudentService;
import com.project.project1.service.StudentServiceImplement;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProfessorServiceTest {

    ProfessorSevrice professorSevrice;

    @Mock
    ProfessorRepository professorRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        professorSevrice = new ProfessorServiceImplement(professorRepository);
    }
    @Test
    public void findAllProfessors() {
        List<Professor> professors = new ArrayList<Professor>();
        Professor professor = new Professor();
       professor.setId(1);
       professor.setFirstName("Mona");
       professor.setLastName("Mona");
        professors.add(professor);
        when(professorRepository.findAll()).thenReturn(professors);
        List<Professor> allProfessors = professorSevrice.findAll();
        assertEquals(allProfessors.size(), 1);
        verify(professorRepository, times(1)).findAll();}
}
