package com.example.fpbm.services;

import com.example.fpbm.entities.Type;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);

    List<Type> fetchAllType();

    Type fetchOneType(Long typeId);

    Type updateType(Type type, Long typeId);

    void deleteType(Long typeId);
}
