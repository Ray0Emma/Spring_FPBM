package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "soutanance")
@Data
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
    private Professeur soutenanceCollectionProfesseur;
    @OneToMany(targetEntity = Jury.class, mappedBy = "jury_idjury")
    private Collection<Jury> jury_idjury;
    @ManyToOne(targetEntity = Salle.class)
    private Salle soutenance_idsoutenance;
    @ManyToOne(targetEntity = PHDStudent.class)
    private PHDStudent soutenance_idPHDstudent ;
}

