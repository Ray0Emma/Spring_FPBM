package com.example.fpbm;

import com.example.fpbm.entities.Departement;
import com.example.fpbm.entities.Filiere;
import com.example.fpbm.entities.Semester;
import com.example.fpbm.repositories.DepartementRepository;
import com.example.fpbm.repositories.FiliereRepository;
import com.example.fpbm.repositories.SemesterRepository;
import com.example.fpbm.services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 @Autowired
     private DepartementRepository departementRepository;

	@Autowired
	private SemesterRepository semesterRepository;

	@Override
	public void run(String... args) throws Exception {
		departementRepository.save(new Departement(4,"iri",null));

	}
}
