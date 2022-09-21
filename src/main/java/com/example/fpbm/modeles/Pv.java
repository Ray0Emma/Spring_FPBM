package com.example.fpbm.modeles;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.OrderedPvs;
import com.example.fpbm.entities.Surveillant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
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
    private String localDate;


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
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = OrderedPvs.class, mappedBy = "pv")
    private Collection<OrderedPvs> orderedPvsCollection;
}
