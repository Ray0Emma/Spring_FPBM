package com.example.fpbm.services;

import com.example.fpbm.entities.Filiere;
import com.example.fpbm.entities.Module;
import com.example.fpbm.entities.Semester;

import java.util.List;

public interface ModuleService {
    Module saveModule(Module module);

    List<Module> fetchAllModule();
    List<Module> findBySemester(Semester semester);

    Module fetchOneModule(Long id);

    Module getModuleByName(String moduleName);

    Module updateModule(Module module, Long id);

    void deleteModule(Long id);
}
