package com.example.fpbm;

import com.example.fpbm.entities.*;
import com.example.fpbm.entities.Module;
import com.example.fpbm.repositories.entitiesRepository.*;
import com.example.fpbm.services.entitiesServices.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
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

	@Autowired
	private RoleRepository roleRepository;




	@Override
	public void run(String... args) throws Exception {
		Role a = roleRepository.save(new Role(1L,"admin"));
		Role p = roleRepository.save(new Role(2L,"teacher"));
		Role e = roleRepository.save(new Role(3L,"student"));

		List<Role> professeurRole = new ArrayList<>();
		List<Role> adminRole = new ArrayList<>();
		List<Role> etudientRole = new ArrayList<>();
		professeurRole.add(p);
		adminRole.add(a);
		etudientRole.add(e);
		Departement d1= departementRepository.save(new Departement(1,"IRI",null));
		Departement d2= departementRepository.save(new Departement(2,"ISI",null));
		Departement d3= departementRepository.save(new Departement(3,"STRI",null));

		Type type1 =  typeRepository.save(new Type(1,"scientifique",null));
		Type type2 =  typeRepository.save(new Type(2,"letteraire",null));

		Extern extern1 = externRepository.save(new Extern(1,null));
		Extern extern2 = externRepository.save(new Extern(2,null));

		LieuDeTravail travail1 = lieuDeTravailRepository.save(new LieuDeTravail(1,null));
		LieuDeTravail travail2 = lieuDeTravailRepository.save(new LieuDeTravail(2,null));

		Professeur professeur1 = professeurRepository.save(new Professeur(1,"anour@gmail.com",  professeurRole,"prof",passwordEncoder().encode("123"),"P345667","D12334555","Salhi","Anouar",new Date(),"beni","0612345678","MR",null,null,travail1,null,extern1,null,null));
		Professeur professeur2 = professeurRepository.save(new Professeur(2,"anour@gmail.com",professeurRole,"prof2","1234","P544666","D3456666","Bbirri","khadija",new Date(),"Ouarzazate","06345665456","MS",null,null,travail2,null,extern1,null,null));
		Professeur professeur3 = professeurRepository.save(new Professeur(3,"anour@gmail.com",adminRole,"admin",passwordEncoder().encode("123"),"P544116","D234556","Robiz","Ayoub",new Date(),"Ouarzazate","06345665456","MR",null,null,travail1,null,extern1,null,null));

		Filiere filiere1 = filiereRepository.save(new Filiere(1,"ISI",d2,type1,professeur1,null,null));
		Filiere filiere2 = filiereRepository.save(new Filiere(2,"SMAI",d2,type1,professeur1,null,null));
		Filiere filiere3 = filiereRepository.save(new Filiere(3,"SMPC",d2,type1,professeur1,null,null));
		Filiere filiere4 = filiereRepository.save(new Filiere(4,"SMI",d2,type1,professeur1,null,null));
		Filiere filiere5 = filiereRepository.save(new Filiere(5,"SMA",d2,type1,professeur1,null,null));
		Filiere filiere6 = filiereRepository.save(new Filiere(6,"DRF",d2,type1,professeur1,null,null));
		Filiere filiere7 = filiereRepository.save(new Filiere(7,"STRI",d2,type1,professeur1,null,null));
		Filiere filiere8 = filiereRepository.save(new Filiere(8,"SVI",d2,type1,professeur1,null,null));
		Filiere filiere9 = filiereRepository.save(new Filiere(9,"SMC",d2,type1,professeur1,null,null));
		Filiere filiere10 = filiereRepository.save(new Filiere(10,"SMP",d2,type1,professeur1,null,null));
		Filiere filiere11 = filiereRepository.save(new Filiere(11,"SEG",d2,type1,professeur1,null,null));

		Etudiant etudiant1 = etudiantRepository.save(new Etudiant(1,"anour@gmail.com",(List<Role>) etudientRole, "etud1", "1234567", "P23456", "D12345678", "Koliche", "mohamed", new Date(), "Ouarzazate", "0634567776", "12345644", filiere1, null,null));
		Etudiant etudiant2 = etudiantRepository.save(new Etudiant(2,"anour@gmail.com",(List<Role>) etudientRole, "etud2", "12367", "P23459", "D12345678", "effg", "mohamed", new Date(), "Ouarzazate", "0634567776", "12345644", filiere1, null,null));
		Etudiant etudiant3 = etudiantRepository.save(new Etudiant(3,"anour@gmail.com",(List<Role>) etudientRole, "etud3", "000", "000", "D12345678", "0000", "0000", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(4,"anour@gmail.com",(List<Role>) etudientRole, "etud4", "000", "000", "D12345678", "ait fal", "ossama", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(5,"anour@gmail.com",(List<Role>) etudientRole, "etud5", "000", "000", "D12345678", "kasmi", "wafi", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(6,"anour@gmail.com",(List<Role>) etudientRole, "etud6", "000", "000", "D12345678", "narin", "ftah", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(7,"anour@gmail.com",(List<Role>) etudientRole, "etud7", "000", "000", "D12345678", "kali", "hakim", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(8,"anour@gmail.com",(List<Role>) etudientRole, "etud8", "000", "000", "D12345678", "hhdhd", "mohamed", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(9,"anour@gmail.com",(List<Role>) etudientRole, "etud9", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(10,"anour@gmail.com",(List<Role>) etudientRole, "etud10", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(11,"anour@gmail.com",(List<Role>) etudientRole, "etud11", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(12,"anour@gmail.com",(List<Role>) etudientRole, "etud12", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(13,"anour@gmail.com",(List<Role>) etudientRole, "etud13", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(14,"anour@gmail.com",(List<Role>) etudientRole, "etud14", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(15,"anour@gmail.com",(List<Role>) etudientRole, "etud15", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(16,"anour@gmail.com",(List<Role>) etudientRole, "etud16", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(17,"anour@gmail.com",(List<Role>) etudientRole, "etud17", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere1, null,null));
		etudiantRepository.save(new Etudiant(18,"anour@gmail.com",(List<Role>) etudientRole, "etud18", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere1, null,null));

		etudiantRepository.save(new Etudiant(19,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(20,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(21,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(22,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(23,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere2, null,null));
		etudiantRepository.save(new Etudiant(24,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere3, null,null));
		etudiantRepository.save(new Etudiant(25,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere3, null,null));
		etudiantRepository.save(new Etudiant(26,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere3, null,null));
		etudiantRepository.save(new Etudiant(27,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere3, null,null));
		etudiantRepository.save(new Etudiant(28,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere3, null,null));

		etudiantRepository.save(new Etudiant(29,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(30,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(31,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(32,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(33,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(34,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(35,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(36,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(37,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere4, null,null));
		etudiantRepository.save(new Etudiant(38,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere4, null,null));

		etudiantRepository.save(new Etudiant(39,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(40,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(41,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(42,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(43,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(44,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(45,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(46,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(47,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere5, null,null));
		etudiantRepository.save(new Etudiant(48,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere5, null,null));

		etudiantRepository.save(new Etudiant(49,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(50,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(51,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(52,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(53,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(54,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(55,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(56,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(57,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere6, null,null));
		etudiantRepository.save(new Etudiant(58,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere6, null,null));

		etudiantRepository.save(new Etudiant(59,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(60,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(61,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(62,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(63,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(64,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(65,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(67,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(68,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere7, null,null));
		etudiantRepository.save(new Etudiant(69,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere7, null,null));

		etudiantRepository.save(new Etudiant(70,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere8, null,null));
		etudiantRepository.save(new Etudiant(71,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere8, null,null));
		etudiantRepository.save(new Etudiant(72,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere8, null,null));
		etudiantRepository.save(new Etudiant(73,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere8, null,null));
		etudiantRepository.save(new Etudiant(74,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere8, null,null));
		etudiantRepository.save(new Etudiant(75,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere8, null,null));
		etudiantRepository.save(new Etudiant(77,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere8, null,null));
		etudiantRepository.save(new Etudiant(78,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere8, null,null));
		etudiantRepository.save(new Etudiant(79,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere8, null,null));
		etudiantRepository.save(new Etudiant(80,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null));

		etudiantRepository.save(new Etudiant(81,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere9, null,null));
		etudiantRepository.save(new Etudiant(82,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere9, null,null));
		etudiantRepository.save(new Etudiant(83,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere9, null,null));
		etudiantRepository.save(new Etudiant(84,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere9, null,null));
		etudiantRepository.save(new Etudiant(85,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere9, null,null));
		etudiantRepository.save(new Etudiant(87,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere9, null,null));
		etudiantRepository.save(new Etudiant(88,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere9, null,null));
		etudiantRepository.save(new Etudiant(89,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere9, null,null));
		etudiantRepository.save(new Etudiant(90,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null));

		etudiantRepository.save(new Etudiant(101,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere10, null,null));
		etudiantRepository.save(new Etudiant(102,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere10, null,null));
		etudiantRepository.save(new Etudiant(103,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere10, null,null));
		etudiantRepository.save(new Etudiant(104,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere10, null,null));
		etudiantRepository.save(new Etudiant(105,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere10, null,null));
		etudiantRepository.save(new Etudiant(107,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere10, null,null));
		etudiantRepository.save(new Etudiant(108,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere10, null,null));
		etudiantRepository.save(new Etudiant(109,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere10, null,null));
		etudiantRepository.save(new Etudiant(110,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null));

		etudiantRepository.save(new Etudiant(111,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere11, null,null));
		etudiantRepository.save(new Etudiant(112,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere11, null,null));
		etudiantRepository.save(new Etudiant(113,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere11, null,null));
		etudiantRepository.save(new Etudiant(114,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere11, null,null));
		etudiantRepository.save(new Etudiant(115,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere11, null,null));
		etudiantRepository.save(new Etudiant(117,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere11, null,null));
		etudiantRepository.save(new Etudiant(118,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere11, null,null));
		etudiantRepository.save(new Etudiant(119,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere11, null,null));
		etudiantRepository.save(new Etudiant(120,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null));
		// TODO: Filier in semester should be a collection :
		Semester semester1 = semesterRepository.save(new Semester(1,"S1_"+filiere1.getName(),null,filiere1));
		Semester semester2 = semesterRepository.save(new Semester(2,"S1_"+filiere2.getName(),null,filiere2));
		Semester semester3 = semesterRepository.save(new Semester(3,"S1_"+filiere3.getName(),null,filiere3));
		Semester semester4 = semesterRepository.save(new Semester(4,"S1_"+filiere4.getName(),null,filiere4));
		Semester semester5 = semesterRepository.save(new Semester(5,"S1_"+filiere5.getName(),null,filiere5));
		Semester semester6 = semesterRepository.save(new Semester(6,"S1_"+filiere6.getName(),null,filiere6));
		Semester semester7 = semesterRepository.save(new Semester(7,"S1_"+filiere7.getName(),null,filiere7));


		Semester semester8 = semesterRepository.save(new Semester(8,"S2_"+filiere1.getName(),null,filiere1));
		Semester semester9 = semesterRepository.save(new Semester(9,"S2_"+filiere2.getName(),null,filiere2));
		Semester semester10 = semesterRepository.save(new Semester(10,"S2_"+filiere3.getName(),null,filiere3));
		Semester semester11 = semesterRepository.save(new Semester(11,"S2_"+filiere4.getName(),null,filiere4));
		Semester semester12 = semesterRepository.save(new Semester(12,"S2_"+filiere5.getName(),null,filiere5));
		Semester semester13 = semesterRepository.save(new Semester(13,"S2_"+filiere6.getName(),null,filiere6));
		Semester semester14 = semesterRepository.save(new Semester(14,"S2_"+filiere7.getName(),null,filiere7));
		Semester semester15 = semesterRepository.save(new Semester(15,"S2_"+filiere8.getName(),null,filiere8));
		Semester semester16 = semesterRepository.save(new Semester(16,"S2_"+filiere9.getName(),null,filiere9));
		Semester semester17 = semesterRepository.save(new Semester(17,"S2_"+filiere10.getName(),null,filiere10));
		Semester semester18 = semesterRepository.save(new Semester(18,"S2_"+filiere11.getName(),null,filiere11));

		Semester semester88 = semesterRepository.save(new Semester(20,"S1_"+filiere8.getName(),null,filiere8));
		Semester semester89 = semesterRepository.save(new Semester(21,"S1_"+filiere9.getName(),null,filiere9));
		Semester semester91 = semesterRepository.save(new Semester(23,"S1_"+filiere11.getName(),null,filiere11));
		Semester semester90 = semesterRepository.save(new Semester(22,"S1_"+filiere10.getName(),null,filiere10));


		ExamenTime examenTime1 = examenTimeRepository.save(new ExamenTime(1,"9h00-10h30", null, null));
		ExamenTime examenTime2 = examenTimeRepository.save(new ExamenTime(2,"13h30-15h00",null, null));
		ExamenTime examenTime3 = examenTimeRepository.save(new ExamenTime(3,"15h30-17h00",null, null));
		ExamenTime examenTime4 = examenTimeRepository.save(new ExamenTime(4,"11h00-12h30",null, null));
		ExamenTime examenTime5 = examenTimeRepository.save(new ExamenTime(5,"16h30-18h00",null, null));
		ExamenTime examenTime6 = examenTimeRepository.save(new ExamenTime(6,"14h45-16h15",null, null));

		//List<ExamenTime> examenTimes = new ArrayList<>();
		//examenTimes.add(examenTime1);


		Salle salle1 = salleRepository.save(new Salle(1,"B01",5,1,null,null,null));
		Salle salle2 = salleRepository.save(new Salle(2,"B02",17,1,null,null,null));
		Salle salle3 = salleRepository.save(new Salle(3,"B03",17,1,null,null,null));
		Salle salle4 = salleRepository.save(new Salle(4,"B04",17,1,null,null,null));
		Salle salle5 = salleRepository.save(new Salle(5,"B05",17,1,null,null,null));
		Salle salle6 = salleRepository.save(new Salle(6,"B06",17,1,null,null,null));
		Salle salle7 = salleRepository.save(new Salle(7,"B07",17,1,null,null,null));

		//TODO: My be there are a problem in model's name :::

		Module model1 = moduleRepository.save(new Module(1,"M33 :Procedure Civile","kk",null,semester6));
		Module model2 = moduleRepository.save(new Module(2,"M33 :Analyse fonctionnelle","kk",null,semester5));
		Module model3 = moduleRepository.save(new Module(3,"M34 :Procedure Penal","kk",null,semester6));
		Module model4 = moduleRepository.save(new Module(4,"M08 :Electrostatique et Electrocinetique","kk",null,semester10));
		Module model5 = moduleRepository.save(new Module(5,"M09 :Droit commercial","kk",null,semester13));
		Module model6 = moduleRepository.save(new Module(6,"M09 :Biologie des Org. Vegetaux","kk",null,semester2));
		Module model8 = moduleRepository.save(new Module(8,"M11 :Physique 3","kk",null,semester9));
		Module model9 = moduleRepository.save(new Module(9,"M08 :Theorie generale des obligations","kk",null,semester13));
		Module model10 = moduleRepository.save(new Module(10,"M08 :Biologie des Org. Animaux","kk",null,semester15));
		Module model11 = moduleRepository.save(new Module(11,"M33 :Base de donnees Oracle","kk",null,semester4));
		Module model12 = moduleRepository.save(new Module(13,"M34 :Controle de Gestion","kk",null,semester91));
		Module model13 = moduleRepository.save(new Module(14,"M33 :Relations economiques internationales","kk",null,semester91));
		Module model14 = moduleRepository.save(new Module(15,"M33 :Audit General","kk",null,semester91));
		Module model15 = moduleRepository.save(new Module(16,"M33 :Theorie des groupes et ses Applications","kk",null,semester90));
		Module model16 = moduleRepository.save(new Module(17,"M33 :Transfert de chaleur","kk",null,semester90));
		Module model17 = moduleRepository.save(new Module(18,"M33 :Electrotechnique","kk",null,semester90));
		Module model18 = moduleRepository.save(new Module(19,"M34 :Chimie descriptive II et chimie de coordination","kk",null,semester89));
		Module model19 = moduleRepository.save(new Module(20,"M33 :Les grandes classes des reactions organiques","kk",null,semester89));
		Module model20 = moduleRepository.save(new Module(21,"M33 :Controle Qualite et Securite Sanitaire des Aliments","kk",null,semester88));
		Module model22 = moduleRepository.save(new Module(22,"M34 :Nutrition et Sciences des Aliments","kk",null,semester88));
		Module model23 = moduleRepository.save(new Module(23,"M09 :Droit Commerciale","kk",null,semester6));
		Module model24 = moduleRepository.save(new Module(24,"M34 :Equations differentielles","kk",null,semester5));
		Module model25 = moduleRepository.save(new Module(25,"M34 :Java Entreprise Edition","kk",null,semester4));
		Module model26 = moduleRepository.save(new Module(26,"M34 :Informatique industrielle","kk",null,semester90));
		Module model27 = moduleRepository.save(new Module(27,"M34 : Mecanique des fluides","kk",null,semester90));
		Module model28 = moduleRepository.save(new Module(28,"M34 :Mecanique quantique relativiste","kk",null,semester90));
		Module model29 = moduleRepository.save(new Module(29,"M09 :Optique geometrique","kk",null,semester10));
		Module model30 = moduleRepository.save(new Module(30,"M12 :Physique 4: Optique 1","kk",null,semester9));

		Surveillant surveillant1 = surveillantRepository.save(new Surveillant(1,"koliche","mohamed",null,professeur1, null,null));
		Surveillant surveillant2 = surveillantRepository.save(new Surveillant(2,"robiz","ayoub",null,professeur2, null,null));
		Surveillant surveillant3 = surveillantRepository.save(new Surveillant(3,"khadija","farah",null,professeur3, null,null));
	}
}
