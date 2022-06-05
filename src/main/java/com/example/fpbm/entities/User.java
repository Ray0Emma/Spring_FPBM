package com.example.fpbm.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String email;
    private String password;
}
