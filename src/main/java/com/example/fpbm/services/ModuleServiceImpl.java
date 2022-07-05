package com.example.fpbm.services;

import com.example.fpbm.entities.Module;
import com.example.fpbm.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModuleServiceImpl implements ModuleService{
    @Autowired
    private ModuleRepository moduleRepository;
    @Override
    public Module saveModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public List<Module> fetchAllModule() {
        return moduleRepository.findAll();
    }

    @Override
    public Module fetchOneModule(Long id) {
        return moduleRepository.findById(id).get();
    }

    @Override
    public Module getModuleByName(String moduleName) {
        return moduleRepository.findByName(moduleName);
    }

    @Override
    public Module updateModule(Module module, Long id) {
        module.setId(id);
        return moduleRepository.save(module);
    }

    @Override
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
