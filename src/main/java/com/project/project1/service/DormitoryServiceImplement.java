package com.project.project1.service;

import com.project.project1.exceptions.ObjectNotFoundException;
import com.project.project1.model.Dormitory;
import com.project.project1.repository.DormitoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DormitoryServiceImplement implements DormitoryService{

    DormitoryRepository dormitoryRepository;

    @Autowired
    public DormitoryServiceImplement(DormitoryRepository dormitoryRepository){
        this.dormitoryRepository = dormitoryRepository;
    }

    @Override
    public List<Dormitory> findAll() {
        List<Dormitory> dormitories = new LinkedList<>();
        dormitoryRepository.findAll().iterator().forEachRemaining(dormitories::add);
        return dormitories;    }

    @Override
    public Dormitory findById(int id) {
        Optional<Dormitory> dormitoryOptional = dormitoryRepository.findById(id);
        if (!dormitoryOptional.isPresent())
        {
            throw new ObjectNotFoundException("Dormitory not found!");
        }
        return dormitoryOptional.get();
    }

    @Override
    public Dormitory addDormitory(Dormitory dormitory) {
        Dormitory savedDormitory = dormitoryRepository.save(dormitory);
        return savedDormitory;
    }
}
