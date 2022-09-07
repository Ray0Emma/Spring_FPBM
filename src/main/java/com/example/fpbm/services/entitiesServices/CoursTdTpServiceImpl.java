package com.example.fpbm.services.entitiesServices;

import com.example.fpbm.entities.Courstdtp;
import com.example.fpbm.repositories.entitiesRepository.CoursTdTpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursTdTpServiceImpl implements CoursTdTpService{

    @Autowired
    private CoursTdTpRepository coursTdTpRepository;


    @Override
    public Courstdtp saveCourstdtp(Courstdtp courstdtp) {
        return coursTdTpRepository.save(courstdtp);
    }

    @Override
    public List<Courstdtp> saveListCourstdtp(List<Courstdtp> courstdtps) {
        return coursTdTpRepository.saveAll(courstdtps);
    }

    @Override
    public List<Courstdtp> fetchAllCourstdtp() {
        return coursTdTpRepository.findAll();
    }

    @Override
    public Courstdtp fetchOneCourstdtp(Long courstdtpId) {
        return coursTdTpRepository.findById(courstdtpId).get();
    }

    @Override
    public Courstdtp updateCourstdtp(Courstdtp courstdtp, Long courstdtpId) {
        courstdtp.setId(courstdtpId);
        return coursTdTpRepository.save(courstdtp);
    }

    @Override
    public void deleteCourstdtp(Long courstdtpId) {
        coursTdTpRepository.deleteById(courstdtpId);
    }
}
