package com.example.fpbm.modeles;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.OrderedPvs;
import com.example.fpbm.entities.Surveillant;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pv {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String local;
    private String filier;
    private String semester;
    private String module;
    private String localDateTime;


    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "Pv_Surveillant",
            joinColumns = @JoinColumn(name = "pv_id"),
            inverseJoinColumns = @JoinColumn(name = "surveillant_id"))
    private List<Surveillant> surveillants;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "Pv_Etudiant",
            joinColumns = @JoinColumn(name = "pv_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private List<Etudiant> etudiants;

    @OneToMany(targetEntity = OrderedPvs.class, mappedBy = "pv")
    private Collection<OrderedPvs> orderedPvsCollection;
}
