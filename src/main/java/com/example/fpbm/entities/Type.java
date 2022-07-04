package com.example.fpbm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;

	@JsonIgnore
	@OneToMany(targetEntity = Filiere.class, mappedBy = "type")
	private Collection<Filiere> filieres;
}
