package com.example.fpbm.repositories;

import com.example.fpbm.entities.Module;
import com.example.fpbm.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    Module findByName(String name);
}
