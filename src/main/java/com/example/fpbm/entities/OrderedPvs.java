package com.example.fpbm.entities;


import com.example.fpbm.modeles.Pv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedPvs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(targetEntity = Pv.class)
    private Pv pv;
    @ManyToOne(targetEntity = Etudiant.class)
    private Etudiant etudiant;
}
