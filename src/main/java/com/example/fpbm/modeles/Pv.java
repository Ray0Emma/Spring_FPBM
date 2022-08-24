package com.example.fpbm.modeles;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.Surveillant;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany
    private List<Surveillant> surveillants;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany
    private List<Etudiant> etudiants;
}
