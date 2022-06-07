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
    @OneToMany( targetEntity= PHDStudent.class, mappedBy="ced_idphdstudent" )
    private Collection<PHDStudent> ced_idphdstudent;
    @OneToMany( targetEntity=Labo.class, mappedBy="ced_idced" )
    private Collection<Labo> ced_idced;
    @OneToMany( targetEntity=Equipe.class, mappedBy="equipe_idequipe" )
    private Collection<Equipe> equipe_idequipe ;
}
