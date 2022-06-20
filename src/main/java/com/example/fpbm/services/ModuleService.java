package com.example.fpbm.services;

import com.example.fpbm.entities.Module;

import java.util.List;

public interface ModuleService {
    Module saveModule(Module module);

    List<Module> fetchAllModule();

    Module fetchOneModule(Long id);

    Module updateModule(Module module, Long id);

    void deleteModule(Long id);
}
