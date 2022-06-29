package com.example.fpbm;

import com.example.fpbm.entities.*;
import com.example.fpbm.repositories.*;
import com.example.fpbm.services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 @Autowired
     private DepartementRepository departementRepository;

	@Autowired
	private SemesterRepository semesterRepository;

	@Autowired
	private TypeRepository typeRepository;

	@Autowired
	private FiliereRepository filiereRepository;

	@Autowired
	private ExternRepository externRepository;

	@Autowired
	private LieuDeTravailRepository lieuDeTravailRepository;

	@Autowired
	private ProfesseurRepository professeurRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;



	@Override
	public void run(String... args) throws Exception {
		Departement d1= departementRepository.save(new Departement(1,"IRI",null));
		Departement d2= departementRepository.save(new Departement(2,"ISI",null));
		Departement d3= departementRepository.save(new Departement(3,"STRI",null));

		Type type1 =  typeRepository.save(new Type(1,"scientifique",null));
		Type type2 =  typeRepository.save(new Type(2,"letteraire",null));

		Extern extern1 = externRepository.save(new Extern(1,null));
		Extern extern2 = externRepository.save(new Extern(2,null));

		LieuDeTravail travail1 = lieuDeTravailRepository.save(new LieuDeTravail(1,null));
		LieuDeTravail travail2 = lieuDeTravailRepository.save(new LieuDeTravail(2,null));

		Professeur professeur1 = professeurRepository.save(new Professeur(1,"anour@gmail.com","123456","P345667","D12334555","Salhi","Anouar",new Date(),"beni","0612345678","MR",null,null,travail1,null,extern1,null,null));
		Professeur professeur2 = professeurRepository.save(new Professeur(2,"khadija@gmail.com","123456","P544666","D3456666","Bbirri","khadija",new Date(),"Ouarzazate","06345665456","MS",null,null,travail2,null,extern1,null,null));

		Filiere filiere1 = filiereRepository.save(new Filiere(1,"SMI",d2,type1,professeur1,null,null));

		Etudiant etudiant1 = etudiantRepository.save(new Etudiant(1, "mohamed@gmail.com", "1234567", "P23456", "D12345678", "Koliche", "mohamed", new Date(), "Ouarzazate", "0634567776", "12345644", filiere1, null));

		Semester semester1 = semesterRepository.save(new Semester(1,"S1",null,filiere1));
		Semester semester2 = semesterRepository.save(new Semester(2,"S2",null,filiere1));

	}
}
