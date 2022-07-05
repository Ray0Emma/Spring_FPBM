package com.example.fpbm.modeles;

import com.example.fpbm.entities.Etudiant;
import com.example.fpbm.entities.Surveillant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pv {
    private String local;
    private String module;
    private LocalDateTime localDateTime;
    private List<Surveillant> surveillants;
    private List<Etudiant> etudiants;
}
