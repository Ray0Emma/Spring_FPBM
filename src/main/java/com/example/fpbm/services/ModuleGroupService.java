package com.example.fpbm.services;
import com.example.fpbm.entities.ModuleGroup;

import java.util.List;

public interface ModuleGroupService {
    ModuleGroup saveModuleGroup(ModuleGroup moduleGroup);

    List<ModuleGroup> fetchAllModuleGroup();

    ModuleGroup fetchOneModuleGroup(Long id);

    ModuleGroup updateModuleGroup(ModuleGroup moduleGroup, Long id);

    void deleteModuleGroup(Long id);
}
