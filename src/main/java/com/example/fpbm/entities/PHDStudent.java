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
    @OneToMany(targetEntity = InInscription.class, mappedBy = "student_idPHDstudent")
    private Collection<InInscription> student_idPHDstudent;
    @OneToMany(targetEntity = Soutenance.class, mappedBy = "soutenance_idPHDstudent")
    private Collection<Soutenance> soutenance_idPHDstudent;
    @ManyToOne(targetEntity = CED.class)
    private CED ced_idphdstudent;
}