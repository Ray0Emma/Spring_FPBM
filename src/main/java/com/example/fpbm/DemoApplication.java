package com.example.fpbm;

import com.example.fpbm.entities.*;
import com.example.fpbm.entities.Module;
import com.example.fpbm.repositories.*;
import com.example.fpbm.services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@Autowired
	private ExamenTimeRepository examenTimeRepository;


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
		Professeur professeur3 = professeurRepository.save(new Professeur(3,"ayoub@gmail.com","123456","P544116","D234556","Robiz","Ayoub",new Date(),"Ouarzazate","06345665456","MR",null,null,travail1,null,extern1,null,null));

		Filiere filiere1 = filiereRepository.save(new Filiere(1,"ISI",d2,type1,professeur1,null,null));
		Filiere filiere2 = filiereRepository.save(new Filiere(2,"SMAI",d2,type1,professeur1,null,null));
		Filiere filiere3 = filiereRepository.save(new Filiere(3,"SMPC",d2,type1,professeur1,null,null));
		Filiere filiere4 = filiereRepository.save(new Filiere(4,"SMI",d2,type1,professeur1,null,null));
		Filiere filiere5 = filiereRepository.save(new Filiere(5,"SMA",d2,type1,professeur1,null,null));
		Filiere filiere6 = filiereRepository.save(new Filiere(6,"DRF",d2,type1,professeur1,null,null));
		Filiere filiere7 = filiereRepository.save(new Filiere(7,"STRI",d2,type1,professeur1,null,null));
		Filiere filiere8 = filiereRepository.save(new Filiere(8,"SVI",d2,type1,professeur1,null,null));



		Etudiant etudiant1 = etudiantRepository.save(new Etudiant(1, "mohamed@gmail.com", "1234567", "P23456", "D12345678", "Koliche", "mohamed", new Date(), "Ouarzazate", "0634567776", "12345644", filiere1, null,null));
		Etudiant etudiant2 = etudiantRepository.save(new Etudiant(2, "mohaayou@gmail.com", "12367", "P23459", "D12345678", "effg", "mohamed", new Date(), "Ouarzazate", "0634567776", "12345644", filiere1, null,null));
		Etudiant etudiant3 = etudiantRepository.save(new Etudiant(3, "589@gmail.com", "000", "000", "D12345678", "0000", "0000", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(4, "589@gmail.com", "000", "000", "D12345678", "ait fal", "ossama", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(5, "589@gmail.com", "000", "000", "D12345678", "kasmi", "wafi", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(6, "589@gmail.com", "000", "000", "D12345678", "narin", "ftah", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(7, "589@gmail.com", "000", "000", "D12345678", "kali", "hakim", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(8, "589@gmail.com", "000", "000", "D12345678", "hhdhd", "mohamed", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(9, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(10, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(11, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(12, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(13, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(14, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(15, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(16, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(17, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(18, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere1, null,null));

		etudiantRepository.save(new Etudiant(19, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(20, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(21, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(22, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(23, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(24, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere3, null,null));
		etudiantRepository.save(new Etudiant(25, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere3, null,null));
		etudiantRepository.save(new Etudiant(26, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere3, null,null));
		etudiantRepository.save(new Etudiant(27, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere3, null,null));
		etudiantRepository.save(new Etudiant(28, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere3, null,null));

		etudiantRepository.save(new Etudiant(29, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(30, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(31, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(32, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(33, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(34, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(35, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(36, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(37, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(38, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere4, null,null));

		etudiantRepository.save(new Etudiant(39, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(40, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(41, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(42, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(43, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(44, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(45, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(46, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(47, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(48, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere5, null,null));

		etudiantRepository.save(new Etudiant(49, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(50, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(51, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(52, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(53, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(54, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(55, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(56, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(57, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(58, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere6, null,null));

		etudiantRepository.save(new Etudiant(59, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(60, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(61, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(62, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(63, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(64, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(65, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(67, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(68, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(69, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere7, null,null));

		// TODO: Filier in semester should be a collection :
		Semester semester1 = semesterRepository.save(new Semester(1,"S1",null,filiere1));
		Semester semester2 = semesterRepository.save(new Semester(2,"S2",null,filiere7));

		ExamenTime examenTime1 = examenTimeRepository.save(new ExamenTime(1,"8", null, null));
		ExamenTime examenTime2 = examenTimeRepository.save(new ExamenTime(2,"13h30-15h00",null, null));
		ExamenTime examenTime3 = examenTimeRepository.save(new ExamenTime(3,"15h30-17h00",null, null));
		ExamenTime examenTime4 = examenTimeRepository.save(new ExamenTime(4,"9h00-10h30",null, null));

		//List<ExamenTime> examenTimes = new ArrayList<>();
		//examenTimes.add(examenTime1);


		Salle salle1 = salleRepository.save(new Salle(1,"B01",16,1,null,null,null));
		Salle salle2 = salleRepository.save(new Salle(2,"B02",3,1,null,null,null));
		Salle salle3 = salleRepository.save(new Salle(3,"B03",3,1,null,null,null));
		Salle salle4 = salleRepository.save(new Salle(4,"B04",5,1,null,null,null));




		//TODO: My be there are a problem in model's name :::

		Module model1 = moduleRepository.save(new Module(1,"Spring","kk",null,semester1));
		Module model111 = moduleRepository.save(new Module(12,"Vue","kk",null,semester2));
		Module model2 = moduleRepository.save(new Module(2,"M33 :Analyse fonctionnelle","kk",null,semester1));
		Module model3 = moduleRepository.save(new Module(3,"M33 :Procédure Civile","kk",null,semester1));
		Module model4 = moduleRepository.save(new Module(4,"M08 :Electrostatique et Electrocinétique","kk",null,semester2));
		Module model5 = moduleRepository.save(new Module(5,"M09 :Droit commercial","kk",null,semester2));
		Module model6 = moduleRepository.save(new Module(6,"M09 :Biologie des Org. Végétaux","kk",null,semester2));
		Module model7 = moduleRepository.save(new Module(7,"M08 :Théorie générale des obligations","kk",null,semester2));
		Module model8 = moduleRepository.save(new Module(8,"M11 :Physique 3","kk",null,semester2));
		Module model9 = moduleRepository.save(new Module(9,"M08 :Théorie générale des obligations","kk",null,semester2));
		Module model10 = moduleRepository.save(new Module(10,"M08 :Biologie des Org. Animaux","kk",null,semester2));
		Module model11 = moduleRepository.save(new Module(11,"M33 :Base de données Oracle","kk",null,semester2));

		Surveillant surveillant1 = surveillantRepository.save(new Surveillant(1,"koliche","mohamed",null,professeur1, null,null));
		Surveillant surveillant2 = surveillantRepository.save(new Surveillant(2,"robiz","ayoub",null,professeur2, null,null));
		Surveillant surveillant3 = surveillantRepository.save(new Surveillant(3,"khadija","farah",null,professeur3, null,null));
	}
}
