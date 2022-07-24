package com.example.fpbm.services;

import com.example.fpbm.entities.LieuDeTravail;
import com.example.fpbm.repositories.LieuDeTravailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LieuDeTravailServiceImpl implements LieuDeTravailService{

    @Autowired
    private LieuDeTravailRepository lieuDeTravailRepository;

    @Override
    public LieuDeTravail saveLieuDeTravail(LieuDeTravail lieuDeTravail) {
        return lieuDeTravailRepository.save(lieuDeTravail);
    }

    @Override
    public LieuDeTravail fetchOneLieuDeTravail(Long lieuDeTravailId) {
        return lieuDeTravailRepository.findById(lieuDeTravailId).get();
    }

    @Override
    public List<LieuDeTravail> fetchAllLieuDeTravail() {
        return lieuDeTravailRepository.findAll();
    }

    @Override
    public LieuDeTravail updateLieuDeTravail(LieuDeTravail lieuDeTravail, Long lieuDeTravailId) {
        lieuDeTravail.setId(lieuDeTravailId);
        return lieuDeTravailRepository.save(lieuDeTravail);
    }

    @Override
    public void deleteLieuDeTravail(Long lieuDeTravailId) {
        lieuDeTravailRepository.deleteById(lieuDeTravailId);
    }

    @Override
    public LieuDeTravail getLieuDeTravail(Long id) {
        return lieuDeTravailRepository.findById(id).orElse(null);
    }
}
