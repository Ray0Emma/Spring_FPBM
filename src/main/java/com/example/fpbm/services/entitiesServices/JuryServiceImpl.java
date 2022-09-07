package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Jury;
import com.example.fpbm.repositories.entitiesRepository.JuryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuryServiceImpl implements JuryService{
    @Autowired
    private JuryRepository juryRepository;
    @Override
    public Jury saveJury(Jury jury) {
        return juryRepository.save(jury);
    }

    @Override
    public Jury fetchOneJury(Long id) {
        return juryRepository.findById(id).get();
    }

    @Override
    public List<Jury> fetchAllJury() {
        return juryRepository.findAll();
    }

    @Override
    public Jury updateJury(Jury jury, Long id) {
        jury.setId(id);
        return juryRepository.save(jury);
    }

    @Override
    public void deleteJury(Long id) {
        juryRepository.deleteById(id);
    }
}
