package com.example.fpbm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @ManyToMany
    @JoinTable( name = "Salle_ExamenTime_Associations",
            joinColumns = @JoinColumn( name = "idTime" ),
            inverseJoinColumns = @JoinColumn( name = "id" ) )
    private List<Salle> salles = new ArrayList<>();


}
