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

	@Autowired
	private ProfesseurHasModuleRepository professeurHasModuleRepository;

	@Autowired
	private  AnneeRepository anneeRepository;

	@Autowired
	private EtudiantHasModuleRepository etudiantHasModuleRepository;




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
		Professeur professeur2 = professeurRepository.save(new Professeur(2,"anour@gmail.com",professeurRole,"prof2",passwordEncoder().encode("123"),"P544666","D3456666","Bbirri","khadija",new Date(),"Ouarzazate","06345665456","MS",null,null,travail2,null,extern1,null,null));
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

		Module model1 = moduleRepository.save(new Module(1,"M33 :Procedure Civile","kk",null,semester6,null));
		Module model2 = moduleRepository.save(new Module(2,"M33 :Analyse fonctionnelle","kk",null,semester5,null));
		Module model3 = moduleRepository.save(new Module(3,"M34 :Procedure Penal","kk",null,semester6,null));
		Module model4 = moduleRepository.save(new Module(4,"M08 :Electrostatique et Electrocinetique","kk",null,semester10,null));
		Module model5 = moduleRepository.save(new Module(5,"M09 :Droit commercial","kk",null,semester13,null));
		Module model6 = moduleRepository.save(new Module(6,"M09 :Biologie des Org. Vegetaux","kk",null,semester2,null));
		Module model8 = moduleRepository.save(new Module(8,"M11 :Physique 3","kk",null,semester9,null));
		Module model9 = moduleRepository.save(new Module(9,"M08 :Theorie generale des obligations","kk",null,semester13,null));
		Module model10 = moduleRepository.save(new Module(10,"M08 :Biologie des Org. Animaux","kk",null,semester15,null));
		Module model11 = moduleRepository.save(new Module(11,"M33 :Base de donnees Oracle","kk",null,semester4,null));
		Module model12 = moduleRepository.save(new Module(13,"M34 :Controle de Gestion","kk",null,semester91,null));
		Module model13 = moduleRepository.save(new Module(14,"M33 :Relations economiques internationales","kk",null,semester91,null));
		Module model14 = moduleRepository.save(new Module(15,"M33 :Audit General","kk",null,semester91,null));
		Module model15 = moduleRepository.save(new Module(16,"M33 :Theorie des groupes et ses Applications","kk",null,semester90,null));
		Module model16 = moduleRepository.save(new Module(17,"M33 :Transfert de chaleur","kk",null,semester90,null));
		Module model17 = moduleRepository.save(new Module(18,"M33 :Electrotechnique","kk",null,semester90,null));
		Module model18 = moduleRepository.save(new Module(19,"M34 :Chimie descriptive II et chimie de coordination","kk",null,semester89,null));
		Module model19 = moduleRepository.save(new Module(20,"M33 :Les grandes classes des reactions organiques","kk",null,semester89,null));
		Module model20 = moduleRepository.save(new Module(21,"M33 :Controle Qualite et Securite Sanitaire des Aliments","kk",null,semester88,null));
		Module model22 = moduleRepository.save(new Module(22,"M34 :Nutrition et Sciences des Aliments","kk",null,semester88,null));
		Module model23 = moduleRepository.save(new Module(23,"M09 :Droit Commerciale","kk",null,semester6,null));
		Module model24 = moduleRepository.save(new Module(24,"M34 :Equations differentielles","kk",null,semester5,null));
		Module model25 = moduleRepository.save(new Module(25,"M34 :Java Entreprise Edition","kk",null,semester4,null));
		Module model26 = moduleRepository.save(new Module(26,"M34 :Informatique industrielle","kk",null,semester90,null));
		Module model27 = moduleRepository.save(new Module(27,"M34 : Mecanique des fluides","kk",null,semester90,null));
		Module model28 = moduleRepository.save(new Module(28,"M34 :Mecanique quantique relativiste","kk",null,semester90,null));
		Module model29 = moduleRepository.save(new Module(29,"M09 :Optique geometrique","kk",null,semester10,null));
		Module model30 = moduleRepository.save(new Module(30,"M12 :Physique 4: Optique 1","kk",null,semester9,null));


		Annee annee1 = anneeRepository.save(new Annee(1,"2021-2022",null,null));
		Annee annee2 = anneeRepository.save(new Annee(2,"2022-2023",null,null));


		List<Module> moduleList1 = new ArrayList<>();
		moduleList1.add(model11);
		moduleList1.add(model25);





		Etudiant etudiant4 =etudiantRepository.save(new Etudiant(5,"koliche@gmail.com",(List<Role>) etudientRole, "koliche1", passwordEncoder().encode("koliche0"), "000", "D12345678", "kasmi", "wafi", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant5 =etudiantRepository.save(new Etudiant(6,"koliche@gmail.com",(List<Role>) etudientRole, "koliche", passwordEncoder().encode("koliche0"), "P360954", "D131431481", "koliche", "mohamed", new Date(), "ouarzazate", "0639951628", "21346244", filiere1, null,null, null));
		Etudiant etudiant6 =etudiantRepository.save(new Etudiant(7,"anour@gmail.com",(List<Role>) etudientRole, "etud8", "000", "000", "D12345678", "hhdhd", "mohamed", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant7 =etudiantRepository.save(new Etudiant(8,"anour@gmail.com",(List<Role>) etudientRole, "etud7", "000", "000", "D12345678", "kali", "hakim", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant8 =etudiantRepository.save(new Etudiant(9,"anour@gmail.com",(List<Role>) etudientRole, "etud9", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant9 =etudiantRepository.save(new Etudiant(10,"anour@gmail.com",(List<Role>) etudientRole, "etud10", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant10 =etudiantRepository.save(new Etudiant(11,"anour@gmail.com",(List<Role>) etudientRole, "etud11", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant11 =etudiantRepository.save(new Etudiant(12,"anour@gmail.com",(List<Role>) etudientRole, "etud12", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant12 =etudiantRepository.save(new Etudiant(13,"anour@gmail.com",(List<Role>) etudientRole, "etud13", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant13 =etudiantRepository.save(new Etudiant(14,"anour@gmail.com",(List<Role>) etudientRole, "etud14", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere1, null,null, null));

		Etudiant etudiant14 =etudiantRepository.save(new Etudiant(15,"anour@gmail.com",(List<Role>) etudientRole, "etud15", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant15 =etudiantRepository.save(new Etudiant(16,"anour@gmail.com",(List<Role>) etudientRole, "etud16", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant16 =etudiantRepository.save(new Etudiant(17,"anour@gmail.com",(List<Role>) etudientRole, "etud17", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant17 =etudiantRepository.save(new Etudiant(18,"anour@gmail.com",(List<Role>) etudientRole, "etud18", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant18 =etudiantRepository.save(new Etudiant(19,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant19 =etudiantRepository.save(new Etudiant(20,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant20 =etudiantRepository.save(new Etudiant(21,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant21 =etudiantRepository.save(new Etudiant(22,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant22 =etudiantRepository.save(new Etudiant(23,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere1, null,null, null));
		Etudiant etudiant23 =etudiantRepository.save(new Etudiant(24,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere1, null,null, null));

		Etudiant etudiant24 =etudiantRepository.save(new Etudiant(25,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere2, null,null, null));
		Etudiant etudiant25 =etudiantRepository.save(new Etudiant(26,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere2, null,null, null));
		Etudiant etudiant26 =etudiantRepository.save(new Etudiant(27,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere2, null,null, null));
		Etudiant etudiant27 =etudiantRepository.save(new Etudiant(28,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere2, null,null, null));
		Etudiant etudiant28 =etudiantRepository.save(new Etudiant(4,"anour@gmail.com",(List<Role>) etudientRole, "etud4", "000", "000", "D12345678", "ait fal", "ossama", new Date(), "0000", "000", "000", filiere2, null,null, null));
		Etudiant etudiant29 =etudiantRepository.save(new Etudiant(29,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere2, null,null, null));
		Etudiant etudiant30 =etudiantRepository.save(new Etudiant(30,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere2, null,null, null));
		Etudiant etudiant31=etudiantRepository.save(new Etudiant(31,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant32=etudiantRepository.save(new Etudiant(32,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant33=etudiantRepository.save(new Etudiant(33,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere2, null,null,null));

		Etudiant etudiant34=etudiantRepository.save(new Etudiant(34,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant35=etudiantRepository.save(new Etudiant(35,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant36=etudiantRepository.save(new Etudiant(36,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant37=etudiantRepository.save(new Etudiant(37,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant38=etudiantRepository.save(new Etudiant(38,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant39=etudiantRepository.save(new Etudiant(39,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant40=etudiantRepository.save(new Etudiant(40,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant41=etudiantRepository.save(new Etudiant(41,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant42=etudiantRepository.save(new Etudiant(42,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere2, null,null,null));
		Etudiant etudiant43=etudiantRepository.save(new Etudiant(43,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere2, null,null,null));

		Etudiant etudiant44=etudiantRepository.save(new Etudiant(44,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant45=etudiantRepository.save(new Etudiant(45,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant46=etudiantRepository.save(new Etudiant(46,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant47=etudiantRepository.save(new Etudiant(47,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant48=etudiantRepository.save(new Etudiant(48,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant49=etudiantRepository.save(new Etudiant(49,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant50=etudiantRepository.save(new Etudiant(50,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant51=etudiantRepository.save(new Etudiant(51,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant52=etudiantRepository.save(new Etudiant(52,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant53=etudiantRepository.save(new Etudiant(53,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere3, null,null,null));

		Etudiant etudiant54=etudiantRepository.save(new Etudiant(54,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant55=etudiantRepository.save(new Etudiant(55,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant56=etudiantRepository.save(new Etudiant(56,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant57=etudiantRepository.save(new Etudiant(57,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant58=etudiantRepository.save(new Etudiant(58,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant59=etudiantRepository.save(new Etudiant(59,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant60=etudiantRepository.save(new Etudiant(60,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant61=etudiantRepository.save(new Etudiant(61,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant62=etudiantRepository.save(new Etudiant(62,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere3, null,null,null));
		Etudiant etudiant63=etudiantRepository.save(new Etudiant(63,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere3, null,null,null));

		Etudiant etudiant64=etudiantRepository.save(new Etudiant(64,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant65=etudiantRepository.save(new Etudiant(65,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant66=etudiantRepository.save(new Etudiant(67,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant67=etudiantRepository.save(new Etudiant(68,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant68=etudiantRepository.save(new Etudiant(69,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant69=etudiantRepository.save(new Etudiant(70,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant70=etudiantRepository.save(new Etudiant(71,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant71=etudiantRepository.save(new Etudiant(72,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant72=etudiantRepository.save(new Etudiant(73,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant73=etudiantRepository.save(new Etudiant(74,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere4, null,null,null));

		Etudiant etudiant74=etudiantRepository.save(new Etudiant(75,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant75=etudiantRepository.save(new Etudiant(77,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant76=etudiantRepository.save(new Etudiant(78,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant77=etudiantRepository.save(new Etudiant(79,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant78=etudiantRepository.save(new Etudiant(80,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant79=etudiantRepository.save(new Etudiant(81,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant80=etudiantRepository.save(new Etudiant(82,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant81=etudiantRepository.save(new Etudiant(83,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant82=etudiantRepository.save(new Etudiant(84,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere4, null,null,null));
		Etudiant etudiant83=etudiantRepository.save(new Etudiant(85,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere4, null,null,null));

		Etudiant etudiant84=etudiantRepository.save(new Etudiant(87,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant85=etudiantRepository.save(new Etudiant(88,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant86=etudiantRepository.save(new Etudiant(89,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant87=etudiantRepository.save(new Etudiant(90,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant88=etudiantRepository.save(new Etudiant(101,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant89=etudiantRepository.save(new Etudiant(102,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant90=etudiantRepository.save(new Etudiant(103,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant91=etudiantRepository.save(new Etudiant(104,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant92=etudiantRepository.save(new Etudiant(105,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant93=etudiantRepository.save(new Etudiant(107,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere5, null,null,null));

		Etudiant etudiant94=etudiantRepository.save(new Etudiant(108,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant95=etudiantRepository.save(new Etudiant(109,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant96=etudiantRepository.save(new Etudiant(110,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant97=etudiantRepository.save(new Etudiant(111,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant98=etudiantRepository.save(new Etudiant(112,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant99=etudiantRepository.save(new Etudiant(113,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant100=etudiantRepository.save(new Etudiant(114,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant101=etudiantRepository.save(new Etudiant(115,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant102=etudiantRepository.save(new Etudiant(116,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere5, null,null,null));
		Etudiant etudiant103=etudiantRepository.save(new Etudiant(117,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere5, null,null,null));

		Etudiant etudiant104=etudiantRepository.save(new Etudiant(118,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant105=etudiantRepository.save(new Etudiant(119,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant106=etudiantRepository.save(new Etudiant(120,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant107=etudiantRepository.save(new Etudiant(121,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant108=etudiantRepository.save(new Etudiant(122,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant109=etudiantRepository.save(new Etudiant(123,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant110=etudiantRepository.save(new Etudiant(124,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant111=etudiantRepository.save(new Etudiant(125,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant112=etudiantRepository.save(new Etudiant(126,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant113=etudiantRepository.save(new Etudiant(127,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere6, null,null,null));

		Etudiant etudiant114=etudiantRepository.save(new Etudiant(128,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant115=etudiantRepository.save(new Etudiant(129,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant116=etudiantRepository.save(new Etudiant(130,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant117=etudiantRepository.save(new Etudiant(131,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant118=etudiantRepository.save(new Etudiant(132,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant119=etudiantRepository.save(new Etudiant(133,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant120=etudiantRepository.save(new Etudiant(134,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant121=etudiantRepository.save(new Etudiant(135,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant122=etudiantRepository.save(new Etudiant(136,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant123=etudiantRepository.save(new Etudiant(137,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));

		Etudiant etudiant124=etudiantRepository.save(new Etudiant(138,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant125=etudiantRepository.save(new Etudiant(139,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant126=etudiantRepository.save(new Etudiant(140,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant127=etudiantRepository.save(new Etudiant(141,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant128=etudiantRepository.save(new Etudiant(142,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant129=etudiantRepository.save(new Etudiant(143,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant130=etudiantRepository.save(new Etudiant(144,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant131=etudiantRepository.save(new Etudiant(145,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant132=etudiantRepository.save(new Etudiant(146,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant133=etudiantRepository.save(new Etudiant(147,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere7, null,null,null));

		Etudiant etudiant134=etudiantRepository.save(new Etudiant(148,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant135=etudiantRepository.save(new Etudiant(149,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant136=etudiantRepository.save(new Etudiant(150,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant137=etudiantRepository.save(new Etudiant(151,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant138=etudiantRepository.save(new Etudiant(152,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant139=etudiantRepository.save(new Etudiant(153,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant140=etudiantRepository.save(new Etudiant(154,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant141=etudiantRepository.save(new Etudiant(155,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant142=etudiantRepository.save(new Etudiant(156,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere7, null,null,null));
		Etudiant etudiant143=etudiantRepository.save(new Etudiant(157,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere7, null,null,null));

		Etudiant etudiant144=etudiantRepository.save(new Etudiant(158,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant145=etudiantRepository.save(new Etudiant(159,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant146=etudiantRepository.save(new Etudiant(160,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant147=etudiantRepository.save(new Etudiant(161,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant148=etudiantRepository.save(new Etudiant(162,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant149=etudiantRepository.save(new Etudiant(163,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant150=etudiantRepository.save(new Etudiant(164,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant151=etudiantRepository.save(new Etudiant(165,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant152=etudiantRepository.save(new Etudiant(166,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant153=etudiantRepository.save(new Etudiant(167,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere8, null,null,null));

		Etudiant etudiant154=etudiantRepository.save(new Etudiant(168,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant155=etudiantRepository.save(new Etudiant(169,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant156=etudiantRepository.save(new Etudiant(170,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant157=etudiantRepository.save(new Etudiant(171,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant158=etudiantRepository.save(new Etudiant(172,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant159=etudiantRepository.save(new Etudiant(173,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant160=etudiantRepository.save(new Etudiant(174,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant161=etudiantRepository.save(new Etudiant(175,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant162=etudiantRepository.save(new Etudiant(176,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant163=etudiantRepository.save(new Etudiant(177,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "000", filiere8, null,null,null));

		Etudiant etudiant164=etudiantRepository.save(new Etudiant(178,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant165=etudiantRepository.save(new Etudiant(179,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant166=etudiantRepository.save(new Etudiant(180,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant167=etudiantRepository.save(new Etudiant(181,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant168=etudiantRepository.save(new Etudiant(182,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant169=etudiantRepository.save(new Etudiant(183,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant170=etudiantRepository.save(new Etudiant(184,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant171=etudiantRepository.save(new Etudiant(185,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant172=etudiantRepository.save(new Etudiant(186,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant173=etudiantRepository.save(new Etudiant(187,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));

		Etudiant etudiant174=etudiantRepository.save(new Etudiant(188,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant175=etudiantRepository.save(new Etudiant(189,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant176=etudiantRepository.save(new Etudiant(190,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant177=etudiantRepository.save(new Etudiant(191,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant178=etudiantRepository.save(new Etudiant(192,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant179=etudiantRepository.save(new Etudiant(193,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant180=etudiantRepository.save(new Etudiant(194,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant181=etudiantRepository.save(new Etudiant(195,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant182=etudiantRepository.save(new Etudiant(196,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));
		Etudiant etudiant183=etudiantRepository.save(new Etudiant(197,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere9, null,null,null));

		Etudiant etudiant184=etudiantRepository.save(new Etudiant(198,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant185=etudiantRepository.save(new Etudiant(199,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant186=etudiantRepository.save(new Etudiant(200,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant187=etudiantRepository.save(new Etudiant(201,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant188=etudiantRepository.save(new Etudiant(202,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant189=etudiantRepository.save(new Etudiant(203,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant190=etudiantRepository.save(new Etudiant(204,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant191=etudiantRepository.save(new Etudiant(205,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant192=etudiantRepository.save(new Etudiant(206,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant193=etudiantRepository.save(new Etudiant(207,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));

		Etudiant etudiant194=etudiantRepository.save(new Etudiant(208,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant195=etudiantRepository.save(new Etudiant(209,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant196=etudiantRepository.save(new Etudiant(210,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant197=etudiantRepository.save(new Etudiant(211,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant198=etudiantRepository.save(new Etudiant(212,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant199=etudiantRepository.save(new Etudiant(213,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant200=etudiantRepository.save(new Etudiant(214,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant201=etudiantRepository.save(new Etudiant(215,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant202=etudiantRepository.save(new Etudiant(216,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant203=etudiantRepository.save(new Etudiant(217,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));

		Etudiant etudiant204=etudiantRepository.save(new Etudiant(218,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant205=etudiantRepository.save(new Etudiant(219,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant206=etudiantRepository.save(new Etudiant(220,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant207=etudiantRepository.save(new Etudiant(221,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant208=etudiantRepository.save(new Etudiant(222,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant209=etudiantRepository.save(new Etudiant(223,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant210=etudiantRepository.save(new Etudiant(224,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant211=etudiantRepository.save(new Etudiant(225,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant212=etudiantRepository.save(new Etudiant(226,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant213=etudiantRepository.save(new Etudiant(227,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));

		Etudiant etudiant214=etudiantRepository.save(new Etudiant(228,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant215=etudiantRepository.save(new Etudiant(229,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant216=etudiantRepository.save(new Etudiant(230,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant217=etudiantRepository.save(new Etudiant(231,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant218=etudiantRepository.save(new Etudiant(232,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant219=etudiantRepository.save(new Etudiant(233,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant220=etudiantRepository.save(new Etudiant(234,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant221=etudiantRepository.save(new Etudiant(235,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant222=etudiantRepository.save(new Etudiant(236,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant223=etudiantRepository.save(new Etudiant(237,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));

		Etudiant etudiant224=etudiantRepository.save(new Etudiant(238,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant225=etudiantRepository.save(new Etudiant(239,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant226=etudiantRepository.save(new Etudiant(240,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant227=etudiantRepository.save(new Etudiant(241,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant228=etudiantRepository.save(new Etudiant(242,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant229=etudiantRepository.save(new Etudiant(243,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant230=etudiantRepository.save(new Etudiant(244,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant231=etudiantRepository.save(new Etudiant(245,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant232=etudiantRepository.save(new Etudiant(246,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant233=etudiantRepository.save(new Etudiant(247,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));

		Etudiant etudiant234=etudiantRepository.save(new Etudiant(248,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant235=etudiantRepository.save(new Etudiant(249,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant236=etudiantRepository.save(new Etudiant(250,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant237=etudiantRepository.save(new Etudiant(251,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant238=etudiantRepository.save(new Etudiant(252,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant239=etudiantRepository.save(new Etudiant(253,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant240=etudiantRepository.save(new Etudiant(254,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant241=etudiantRepository.save(new Etudiant(255,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant242=etudiantRepository.save(new Etudiant(256,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));
		Etudiant etudiant243=etudiantRepository.save(new Etudiant(257,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere6, null,null,null));

		Etudiant etudiant244=etudiantRepository.save(new Etudiant(258,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant245=etudiantRepository.save(new Etudiant(259,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant246=etudiantRepository.save(new Etudiant(260,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant247=etudiantRepository.save(new Etudiant(261,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant248=etudiantRepository.save(new Etudiant(262,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant249=etudiantRepository.save(new Etudiant(263,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant250=etudiantRepository.save(new Etudiant(264,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant251=etudiantRepository.save(new Etudiant(265,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant252=etudiantRepository.save(new Etudiant(266,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant253=etudiantRepository.save(new Etudiant(267,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));

		Etudiant etudiant254=etudiantRepository.save(new Etudiant(228,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant255=etudiantRepository.save(new Etudiant(229,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant256=etudiantRepository.save(new Etudiant(230,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant257=etudiantRepository.save(new Etudiant(231,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant258=etudiantRepository.save(new Etudiant(232,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant259=etudiantRepository.save(new Etudiant(233,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant260=etudiantRepository.save(new Etudiant(234,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant261=etudiantRepository.save(new Etudiant(235,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant262=etudiantRepository.save(new Etudiant(236,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));
		Etudiant etudiant263=etudiantRepository.save(new Etudiant(237,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere8, null,null,null));

		Etudiant etudiant264=etudiantRepository.save(new Etudiant(238,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant265=etudiantRepository.save(new Etudiant(239,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant266=etudiantRepository.save(new Etudiant(240,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant267=etudiantRepository.save(new Etudiant(241,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant268=etudiantRepository.save(new Etudiant(242,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant269=etudiantRepository.save(new Etudiant(243,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant270=etudiantRepository.save(new Etudiant(244,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant271=etudiantRepository.save(new Etudiant(245,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant272=etudiantRepository.save(new Etudiant(246,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant273=etudiantRepository.save(new Etudiant(247,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));

		Etudiant etudiant274=etudiantRepository.save(new Etudiant(248,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant275=etudiantRepository.save(new Etudiant(249,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant276=etudiantRepository.save(new Etudiant(250,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant277=etudiantRepository.save(new Etudiant(251,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant278=etudiantRepository.save(new Etudiant(252,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant279=etudiantRepository.save(new Etudiant(253,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant280=etudiantRepository.save(new Etudiant(254,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant281=etudiantRepository.save(new Etudiant(255,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant282=etudiantRepository.save(new Etudiant(256,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));
		Etudiant etudiant283=etudiantRepository.save(new Etudiant(257,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere10, null,null,null));

		Etudiant etudiant284=etudiantRepository.save(new Etudiant(258,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant285=etudiantRepository.save(new Etudiant(259,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant286=etudiantRepository.save(new Etudiant(260,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant287=etudiantRepository.save(new Etudiant(261,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant288=etudiantRepository.save(new Etudiant(262,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant289=etudiantRepository.save(new Etudiant(263,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant290=etudiantRepository.save(new Etudiant(264,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant291=etudiantRepository.save(new Etudiant(265,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant292=etudiantRepository.save(new Etudiant(266,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));
		Etudiant etudiant293=etudiantRepository.save(new Etudiant(267,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "000", filiere11, null,null,null));


		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant4, model11));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant5, model11));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant6, model11));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant7, model11));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant8, model11));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant9, model11));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant10, model11));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant11, model11));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant12, model11));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant13, model11));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant14, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant15, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant16, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant17, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant18, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant19, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant20, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant21, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant22, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant23, model25));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant24, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant25, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant26, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant27, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant28, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant29, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant30, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant31, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant32, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant33, model8));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant34, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant35, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant36, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant37, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant38, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant39, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant40, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant41, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant42, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant43, model30));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant44, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant45, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant46, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant47, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant48, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant49, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant50, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant51, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant52, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant53, model29));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant54, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant55, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant56, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant57, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant58, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant59, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant60, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant61, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant62, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant63, model4));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant64, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant65, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant66, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant67, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant68, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant69, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant70, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant71, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant72, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant73, model24));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant74, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant75, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant76, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant77, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant78, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant79, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant80, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant81, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant82, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant83, model2));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant84, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant85, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant86, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant87, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant88, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant89, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant90, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant91, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant92, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant93, model15));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant94, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant95, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant96, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant97, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant98, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant99, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant100, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant101, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant102, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant103, model28));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant104, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant105, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant106, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant107, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant108, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant109, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant110, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant111, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant112, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant113, model1));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant114, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant115, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant116, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant117, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant118, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant119, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant120, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant121, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant122, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant123, model3));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant124, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant125, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant126, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant127, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant128, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant129, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant130, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant131, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant132, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant133, model17));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant134, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant135, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant136, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant137, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant138, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant139, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant140, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant141, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant142, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant143, model26));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant144, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant145, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant146, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant147, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant148, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant149, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant150, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant151, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant152, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant153, model20));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant154, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant155, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant156, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant157, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant158, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant159, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant160, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant161, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant162, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant163, model22));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant164, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant165, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant166, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant167, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant168, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant169, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant170, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant171, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant172, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant173, model19));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant174, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant175, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant176, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant177, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant178, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant179, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant180, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant181, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant182, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant183, model18));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant184, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant185, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant186, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant187, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant188, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant189, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant190, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant191, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant192, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant193, model16));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant194, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant195, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant196, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant197, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant198, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant199, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant200, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant201, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant202, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant203, model27));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant204, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant205, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant206, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant207, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant208, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant209, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant210, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant211, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant212, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant213, model14));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant214, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant215, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant216, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant217, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant218, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant219, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant220, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant221, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant222, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant223, model12));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant224, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant225, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant226, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant227, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant228, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant229, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant230, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant231, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant232, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant233, model5));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant234, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant235, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant236, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant237, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant238, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant239, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant240, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant241, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant242, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant243, model9));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant244, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant245, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant246, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant247, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant248, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant249, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant250, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant251, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant252, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant253, model6));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant254, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant255, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant256, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant257, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant258, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant259, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant260, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant261, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant262, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant263, model10));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant264, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant265, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant266, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant267, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant268, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant269, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant270, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant271, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant272, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant273, model15));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant274, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant275, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant276, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant277, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant278, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant279, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant280, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant281, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant282, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant283, model28));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant284, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant285, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant286, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant287, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant288, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant289, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant290, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant291, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant292, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant293, model13));





		ProfesseurHasModule professeurHasModule1 = professeurHasModuleRepository.save(new ProfesseurHasModule(1, annee1, professeur1, model11, null));
		ProfesseurHasModule professeurHasModule2 = professeurHasModuleRepository.save(new ProfesseurHasModule(2, annee1, professeur1, model25, null));
		ProfesseurHasModule professeurHasModule3 = professeurHasModuleRepository.save(new ProfesseurHasModule(3, annee1, professeur1, model2, null));
		ProfesseurHasModule professeurHasModule4 = professeurHasModuleRepository.save(new ProfesseurHasModule(4, annee1, professeur2, model1, null));
		ProfesseurHasModule professeurHasModule5 = professeurHasModuleRepository.save(new ProfesseurHasModule(5, annee1, professeur2, model3, null));
		ProfesseurHasModule professeurHasModule6 = professeurHasModuleRepository.save(new ProfesseurHasModule(6, annee1, professeur2, model4, null));





		Surveillant surveillant1 = surveillantRepository.save(new Surveillant(1,"koliche","mohamed",null,professeur1, null,null));
		Surveillant surveillant2 = surveillantRepository.save(new Surveillant(2,"robiz","ayoub",null,professeur2, null,null));
		Surveillant surveillant3 = surveillantRepository.save(new Surveillant(3,"khadija","farah",null,professeur3, null,null));
	}
}
