package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "phdstudent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PHDStudent extends Etudiant{
    @OneToMany(targetEntity = InInscription.class, mappedBy = "phdStudent")
    private Collection<InInscription> inInscriptions;
    @OneToMany(targetEntity = Soutenance.class, mappedBy = "phdStudent")
    private Collection<Soutenance> soutenances;
    @ManyToOne(targetEntity = CED.class)
    private CED ced;
}