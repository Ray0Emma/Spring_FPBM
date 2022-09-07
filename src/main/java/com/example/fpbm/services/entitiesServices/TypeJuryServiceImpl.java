package com.example.fpbm.services.entitiesServices;
import com.example.fpbm.entities.TypeJury;
import com.example.fpbm.repositories.entitiesRepository.TypeJuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeJuryServiceImpl implements TypeJuryService{
    @Autowired
    private TypeJuryRepository typeJuryRepository;

    @Override
    public TypeJury saveTypeJury(TypeJury typeJury) {
        return typeJuryRepository.save(typeJury);
    }

    @Override
    public List<TypeJury> fetchAllTypeJury() {
        return typeJuryRepository.findAll();
    }

    @Override
    public TypeJury fetchOneTypeJury(Long id) {
        return typeJuryRepository.findById(id).get();
    }

    @Override
    public TypeJury updateTypeJury(TypeJury typeJury, Long id) {
        typeJury.setId(id);
        return typeJuryRepository.save(typeJury);
    }

    @Override
    public void deleteTypeJury(Long id) {
        typeJuryRepository.deleteById(id);
    }
}
