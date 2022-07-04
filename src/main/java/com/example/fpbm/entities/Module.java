package com.example.fpbm.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "module")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "Groupe")
    private String Groupe;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity=ProfesseurHasModule.class, mappedBy="module")
    private Collection<ProfesseurHasModule> professeurHasModules;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity=Semester.class)
    private Semester semester;
}
