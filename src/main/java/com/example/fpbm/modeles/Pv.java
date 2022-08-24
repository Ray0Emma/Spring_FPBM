package com.example.fpbm.modeles;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.Surveillant;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pv {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String local;
    private String filier;
    private String semester;
    private String module;
    private String localDateTime;
    //private List<Surveillant> surveillants;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = Etudiant.class,mappedBy = "pv")
    private List<Etudiant> etudiants;
}
