package com.example.fpbm.services;

import com.example.fpbm.entities.Extern;
import com.example.fpbm.entities.Filiere;
import com.example.fpbm.repositories.ExternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternServiceImpl implements ExternService{

    @Autowired
    private ExternRepository externRepository;

    @Override
    public Extern saveExtern(Extern extern) {
        return externRepository.save(extern);
    }

    @Override
    public Extern fetchOneExtern(Long externId) {
        return externRepository.getById(externId);
    }

    @Override
    public List<Extern> fetchAllExtern() {
        return externRepository.findAll();
    }

    @Override
    public Extern updateExtern(Extern extern, Long externId) {
        extern.setId(externId);
        return externRepository.save(extern);
    }

    @Override
    public void deleteExtern(Long externId) {
        externRepository.deleteById(externId);
    }
    public Extern getExtern(Long id) {
        return externRepository.findById(id).orElse(null);
    }
}
