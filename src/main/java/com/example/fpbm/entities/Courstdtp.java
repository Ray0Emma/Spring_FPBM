package com.example.fpbm.entities;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "courstdtp")
public class Courstdtp {
    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcourstdtp;
    @Column(name = "name")
    private String name;
    @OneToMany( targetEntity=ProfesseurHasModule.class, mappedBy="professeurHasModuleCollectionCoursTDTP" )
    private Collection<ProfesseurHasModule> professeurHasModuleCollectionCoursTDTP;
}