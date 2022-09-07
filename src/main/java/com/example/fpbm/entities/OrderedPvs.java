package com.example.fpbm.entities;


import com.example.fpbm.modeles.Pv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
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

    @Column(name = "etudient_order")
    private long etudientOrder;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity = Pv.class)
    private Pv pv;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity = Etudiant.class)
    private Etudiant etudiant;
}
