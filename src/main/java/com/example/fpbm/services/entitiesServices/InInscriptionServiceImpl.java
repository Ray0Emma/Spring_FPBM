package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.InInscription;
import com.example.fpbm.repositories.entitiesRepository.InInscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InInscriptionServiceImpl implements InInscriptionService{
    @Autowired
    private InInscriptionRepository inInscriptionRepository;
    @Override
    public InInscription saveInInscription(InInscription inInscription) {
        return inInscriptionRepository.save(inInscription);
    }

    @Override
    public List<InInscription> fetchAllInInscription() {
        return inInscriptionRepository.findAll();
    }

    @Override
    public InInscription fetchOneInInscription(Long id) {
        return inInscriptionRepository.findById(id).get();
    }

    @Override
    public InInscription updateInInscription(InInscription inInscription, Long id) {
        inInscription.setId(id);
        return inInscriptionRepository.save(inInscription);
    }

    @Override
    public void deleteInInscription(Long id) {
        inInscriptionRepository.deleteById(id);
    }
}
