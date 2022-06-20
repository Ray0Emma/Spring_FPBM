package com.example.fpbm.services;
import com.example.fpbm.entities.InInscription;

import java.util.List;

public interface InInscriptionService {
    InInscription saveInInscription(InInscription inInscription);

    List<InInscription> fetchAllInInscription();

    InInscription fetchOneInInscription(Long id);

    InInscription updateInInscription(InInscription inInscription, Long id);

    void deleteInInscription(Long id);
}
