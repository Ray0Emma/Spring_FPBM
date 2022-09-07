package com.example.fpbm.services.entitiesServices;



import com.example.fpbm.entities.Courstdtp;

import java.util.List;

public interface CoursTdTpService {

    Courstdtp saveCourstdtp(Courstdtp courstdtp);

    List<Courstdtp> saveListCourstdtp(List<Courstdtp> courstdtps);

    List<Courstdtp> fetchAllCourstdtp();

    Courstdtp fetchOneCourstdtp(Long courstdtpId);

    Courstdtp updateCourstdtp(Courstdtp courstdtp, Long courstdtpId);

    void deleteCourstdtp(Long courstdtpId);
}
