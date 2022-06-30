package com.example.fpbm.services;

import com.example.fpbm.entities.Section;
import com.example.fpbm.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService{

    @Autowired
    private SectionRepository sectionRepository;


    @Override
    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public List<Section> saveListSection(List<Section> sections) {
        return sectionRepository.saveAll(sections);
    }

    @Override
    public List<Section> fetchAllSection() {
        return sectionRepository.findAll();
    }

    @Override
    public Section fetchOneSection(Long sectionId) {
        return sectionRepository.findById(sectionId).get();
    }

    @Override
    public Section updateSection(Section section, Long sectionId) {
        section.setId(sectionId);
        return sectionRepository.save(section);
    }

    @Override
    public void deleteSection(Long sectionId) {
        sectionRepository.deleteById(sectionId);
    }
}
