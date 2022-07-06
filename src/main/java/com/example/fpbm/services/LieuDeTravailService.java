package com.example.fpbm.services;

import com.example.fpbm.entities.Extern;
import com.example.fpbm.entities.LieuDeTravail;


import java.util.List;

public interface LieuDeTravailService {

    LieuDeTravail saveLieuDeTravail(LieuDeTravail lieuDeTravail);

    LieuDeTravail fetchOneLieuDeTravail(Long lieuDeTravailId);

    List<LieuDeTravail> fetchAllLieuDeTravail();

    LieuDeTravail updateLieuDeTravail(LieuDeTravail lieuDeTravail, Long lieuDeTravailId);

    void deleteLieuDeTravail(Long lieuDeTravailId);

    LieuDeTravail getLieuDeTravail(Long id) ;
}
