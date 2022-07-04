package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "soutenance")
@NoArgsConstructor
@AllArgsConstructor
public class Soutenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sujet")
    private String sujet;
    @Column(name = "date")
    private String date;
    @Column(name = "soutenancecol")
    private String soutenanccol;
    @ManyToOne(targetEntity = Professeur.class)
    private Professeur professeur;
    @OneToMany(targetEntity = Jury.class, mappedBy = "soutenance")
    private Collection<Jury> juries;
    @ManyToOne(targetEntity = Salle.class)
    private Salle salle;
    @ManyToOne(targetEntity = PHDStudent.class)
    private PHDStudent phdStudent ;
}

