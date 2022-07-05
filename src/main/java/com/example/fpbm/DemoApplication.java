package com.example.fpbm;

import com.example.fpbm.entities.*;
import com.example.fpbm.entities.Module;
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
	private ModuleRepository moduleRepository;
	@Autowired
	private SemesterRepository semesterRepository;

	@Autowired
	private SalleRepository salleRepository;

	@Autowired
	private SurveillantRepository surveillantRepository;

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

		Filiere filiere1 = filiereRepository.save(new Filiere(1,"ISI",d2,type1,professeur1,null,null));
		Filiere filiere2 = filiereRepository.save(new Filiere(2,"STRI",d2,type1,professeur1,null,null));
		Etudiant etudiant1 = etudiantRepository.save(new Etudiant(1, "mohamed@gmail.com", "1234567", "P23456", "D12345678", "Koliche", "mohamed", new Date(), "Ouarzazate", "0634567776", "12345644", filiere1, null));
		Etudiant etudiant2 = etudiantRepository.save(new Etudiant(2, "mohaayou@gmail.com", "12367", "P23459", "D12345678", "effg", "mohamed", new Date(), "Ouarzazate", "0634567776", "12345644", filiere1, null));
		Etudiant etudiant3 = etudiantRepository.save(new Etudiant(3, "589@gmail.com", "000", "000", "D12345678", "0000", "0000", new Date(), "0000", "000", "000", filiere2, null));

		Semester semester1 = semesterRepository.save(new Semester(1,"S1",null,filiere1));
		Semester semester2 = semesterRepository.save(new Semester(2,"S2",null,filiere1));

		Salle salle1 = salleRepository.save(new Salle(1,"B01",3,4,null,null));
		Salle salle2 = salleRepository.save(new Salle(2,"B02",3,4,null,null));
		Module model1 = moduleRepository.save(new Module(1,"Spring","kk",null,semester1));

		Surveillant surveillant1 = surveillantRepository.save(new Surveillant(1,"koliche","vd",null,professeur1));
		Surveillant surveillant2 = surveillantRepository.save(new Surveillant(2,"robiz","we",null,professeur2));
		Surveillant surveillant3 = surveillantRepository.save(new Surveillant(3,"mee","vvx",null,professeur1));
	}
}
