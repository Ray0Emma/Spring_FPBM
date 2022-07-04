package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "typejury")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeJury {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany( targetEntity=Jury.class, mappedBy="typeJury" )
    private Collection<Jury> juries;


}
