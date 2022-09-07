package com.example.fpbm.services.entitiesServices;



import com.example.fpbm.entities.Section;

import java.util.List;

public interface SectionService {

    Section saveSection(Section section);

    List<Section> saveListSection(List<Section> sections);

    List<Section> fetchAllSection();

    Section fetchOneSection(Long sectionId);

    Section updateSection(Section section, Long sectionId);

    void deleteSection(Long sectionId);
}
