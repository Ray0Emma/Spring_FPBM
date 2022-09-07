package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Equipe;
import com.example.fpbm.repositories.entitiesRepository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService{
    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public Equipe saveEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> fetchAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe fetchOneEquipe(Long id) {
        return equipeRepository.findById(id).get();
    }

    @Override
    public Equipe updateEquipe(Equipe equipe, Long id) {
        equipe.setId(id);
        return equipeRepository.save(equipe);
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }
}
