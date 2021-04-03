package com.project.project1.services;

import com.project.project1.model.Dormitory;
import com.project.project1.model.Student;
import com.project.project1.repository.DormitoryRepository;
import com.project.project1.repository.StudentRepository;
import com.project.project1.service.DormitoryService;
import com.project.project1.service.DormitoryServiceImplement;
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

public class DormitoryServiceTest {

    DormitoryService dormitoryService;

    @Mock
    DormitoryRepository dormitoryRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        dormitoryService = new DormitoryServiceImplement(dormitoryRepository);
    }
    @Test
    public void findAllDormitories() {
        List<Dormitory> dormitories = new ArrayList<Dormitory>();
        Dormitory dormitory = new Dormitory();
       dormitory.setId(1);
       dormitory.setName("west side 5");
       dormitory.setCapacity(300);
        dormitories.add(dormitory);
        when(dormitoryRepository.findAll()).thenReturn(dormitories);
        List<Dormitory> allDormitories = dormitoryService.findAll();
        assertEquals(allDormitories.size(), 1);
        verify(dormitoryRepository, times(1)).findAll();}
}
