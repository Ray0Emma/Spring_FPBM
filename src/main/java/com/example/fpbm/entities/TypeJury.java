package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "typejury")
@NoArgsConstructor
@AllArgsConstructor
public class TypeJury {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany( targetEntity=Jury.class, mappedBy="type_idtypejury" )
    private Collection<Jury> type_idtypejury;


}
