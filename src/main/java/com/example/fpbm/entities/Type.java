package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "type")
@NoArgsConstructor
@AllArgsConstructor
public class Type {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    @Column(name = "name")
	    private String name;
	    @OneToMany(targetEntity = Filiere.class, mappedBy = "filiereCollectionType")
	    private Collection<Filiere> filiereCollectionType;
}
