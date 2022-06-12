package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ininscription")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InInscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dateInscription")
    private String dateInscription;

    @ManyToOne(targetEntity= PHDStudent.class)
    private PHDStudent student_idPHDstudent;
}

