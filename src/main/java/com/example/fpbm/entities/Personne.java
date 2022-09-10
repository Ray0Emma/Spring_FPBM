package com.example.fpbm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;
import java.util.List;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Personne extends User{

    private String cin;
    private String cne;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String Address;
    private String telephone;

    public Personne(long id, String email, List<Role> roles, String username, String password, String cin, String cne, String nom, String prenom, Date dateDeNaissance, String address, String telephone) {
        super(id,username, email, password,roles);
        this.cin = cin;
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        Address = address;
        this.telephone = telephone;
    }
}
