package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ced")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CED {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany( targetEntity= PHDStudent.class, mappedBy="ced" )
    private Collection<PHDStudent> phdStudents;
    @OneToMany( targetEntity=Labo.class, mappedBy="ced" )
    private Collection<Labo> labos;
    @OneToMany( targetEntity=Equipe.class, mappedBy="ced" )
    private Collection<Equipe> equipes ;
}
