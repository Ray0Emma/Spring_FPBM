package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "phdstudent")
@NoArgsConstructor
@AllArgsConstructor
public class PHDStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(targetEntity = InInscription.class, mappedBy = "student_idPHDstudent")
    private Collection<InInscription> student_idPHDstudent;
    @OneToMany(targetEntity = Soutenance.class, mappedBy = "soutenance_idPHDstudent")
    private Collection<Soutenance> soutenance_idPHDstudent;
    @ManyToOne(targetEntity = CED.class)
    private CED ced_idphdstudent;
}
