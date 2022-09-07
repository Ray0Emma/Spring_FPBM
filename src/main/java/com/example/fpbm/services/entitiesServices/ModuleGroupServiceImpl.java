package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.ModuleGroup;
import com.example.fpbm.repositories.entitiesRepository.ModuleGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleGroupServiceImpl implements ModuleGroupService{
    @Autowired
    private ModuleGroupRepository moduleGroupRepository;
    @Override
    public ModuleGroup saveModuleGroup(ModuleGroup moduleGroup) {
        return moduleGroupRepository.save(moduleGroup);
    }

    @Override
    public List<ModuleGroup> fetchAllModuleGroup() {
        return moduleGroupRepository.findAll();
    }

    @Override
    public ModuleGroup fetchOneModuleGroup(Long id) {
        return moduleGroupRepository.findById(id).get();
    }

    @Override
    public ModuleGroup updateModuleGroup(ModuleGroup moduleGroup, Long id) {
        moduleGroup.setId(id);
        return moduleGroupRepository.save(moduleGroup);
    }

    @Override
    public void deleteModuleGroup(Long id) {
        moduleGroupRepository.deleteById(id);
    }
}
