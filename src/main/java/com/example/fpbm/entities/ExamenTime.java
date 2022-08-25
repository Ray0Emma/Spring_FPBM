package com.example.fpbm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamenTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTime;
    @Column(name = "time")
    private String time;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable( name = "Salle_ExamenTime_Associations",
            joinColumns = @JoinColumn( name = "idTime" ),
            inverseJoinColumns = @JoinColumn( name = "id" ) )
    private List<Salle> salles = new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "Surveillant_ExamenTime",
            joinColumns = @JoinColumn(name = "examenTime_id"),
            inverseJoinColumns = @JoinColumn(name = "surveillant_id"))
    private List<Surveillant> surveillants;

}
