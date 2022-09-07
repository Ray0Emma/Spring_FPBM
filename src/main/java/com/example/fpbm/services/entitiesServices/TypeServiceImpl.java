package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Type;
import com.example.fpbm.repositories.entitiesRepository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public List<Type> fetchAllType() {
        return (List<Type>) typeRepository.findAll();
    }

    @Override
    public Type fetchOneType(Long typeId) {
        return typeRepository.findById(typeId).get();
    }

    @Override
    public Type updateType(Type type, Long typeId) {
        type.setId(typeId);
        return typeRepository.save(type);
    }

    @Override
    public void deleteType(Long typeId) {
        typeRepository.deleteById(typeId);
    }
}
