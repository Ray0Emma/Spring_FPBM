package com.example.fpbm.services.PvServices;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.OrderedPvs;
import com.example.fpbm.modeles.Pv;

import java.util.List;

public interface OrderedPvsService {
    OrderedPvs saveOrderPv(OrderedPvs orderedPvs);
    List<OrderedPvs> saveListOrderPvs(List<OrderedPvs> orderedPvsList);
    List<OrderedPvs> fetchAllOrderPvs();
    OrderedPvs fetchOneOrderPv(Long id);
    OrderedPvs updateOrderPv(OrderedPvs orderedPvs,Long id);

    OrderedPvs findOrderByEtudiantAndPV(Etudiant etudiant,Pv pv);
    void deleteOrderPv(Long id);


}
