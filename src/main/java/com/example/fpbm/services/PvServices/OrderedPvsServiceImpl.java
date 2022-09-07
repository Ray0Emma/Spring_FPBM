package com.example.fpbm.services.PvServices;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.OrderedPvs;
import com.example.fpbm.modeles.Pv;
import com.example.fpbm.repositories.pvRepository.OrderedPvsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedPvsServiceImpl implements OrderedPvsService{
    @Autowired
    private OrderedPvsRepository orderedPvsRepository;
    @Override
    public OrderedPvs saveOrderPv(OrderedPvs orderedPvs) {
        return orderedPvsRepository.save(orderedPvs);
    }

    @Override
    public List<OrderedPvs> saveListOrderPvs(List<OrderedPvs> orderedPvsList) {
        return orderedPvsRepository.saveAll(orderedPvsList);
    }

    @Override
    public List<OrderedPvs> fetchAllOrderPvs() {
        return orderedPvsRepository.findAll();
    }

    @Override
    public OrderedPvs fetchOneOrderPv(Long id) {
        return orderedPvsRepository.findById(id).get();
    }

    @Override
    public OrderedPvs updateOrderPv(OrderedPvs orderedPvs, Long id) {
        orderedPvs.setId(id);
        return orderedPvsRepository.save(orderedPvs);
    }

    @Override
    public OrderedPvs findOrderByEtudiantAndPV(Etudiant etudiant, Pv pv) {
        return orderedPvsRepository.findOrderedPvsByEtudiantAndPv(etudiant,pv);
    }

    @Override
    public void deleteOrderPv(Long id) {
        orderedPvsRepository.deleteById(id);
    }
}
