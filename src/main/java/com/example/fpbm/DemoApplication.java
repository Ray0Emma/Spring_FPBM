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
		Etudiant etudiant6 =etudiantRepository.save(new Etudiant(7,"anour@gmail.com",(List<Role>) etudientRole, "etud8", "000", "000", "D12345678", "hhdhd", "mohamed", new Date(), "0000", "000", "0001", filiere1, null,null, null));
		Etudiant etudiant7 =etudiantRepository.save(new Etudiant(8,"anour@gmail.com",(List<Role>) etudientRole, "etud7", "000", "000", "D12345678", "kali", "hakim", new Date(), "0000", "000", "0002", filiere1, null,null, null));
		Etudiant etudiant8 =etudiantRepository.save(new Etudiant(9,"anour@gmail.com",(List<Role>) etudientRole, "etud9", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "0003", filiere1, null,null, null));
		Etudiant etudiant9 =etudiantRepository.save(new Etudiant(10,"anour@gmail.com",(List<Role>) etudientRole, "etud10", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0004", filiere1, null,null, null));
		Etudiant etudiant10 =etudiantRepository.save(new Etudiant(11,"anour@gmail.com",(List<Role>) etudientRole, "etud11", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0005", filiere1, null,null, null));
		Etudiant etudiant11 =etudiantRepository.save(new Etudiant(12,"anour@gmail.com",(List<Role>) etudientRole, "etud12", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0006", filiere1, null,null, null));
		Etudiant etudiant12 =etudiantRepository.save(new Etudiant(13,"anour@gmail.com",(List<Role>) etudientRole, "etud13", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0007", filiere1, null,null, null));
		Etudiant etudiant13 =etudiantRepository.save(new Etudiant(14,"anour@gmail.com",(List<Role>) etudientRole, "etud14", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0008", filiere1, null,null, null));

		Etudiant etudiant14 =etudiantRepository.save(new Etudiant(15,"anour@gmail.com",(List<Role>) etudientRole, "etud15", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0009", filiere2, null,null, null));
		Etudiant etudiant15 =etudiantRepository.save(new Etudiant(16,"anour@gmail.com",(List<Role>) etudientRole, "etud16", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0010", filiere2, null,null, null));
		Etudiant etudiant16 =etudiantRepository.save(new Etudiant(17,"anour@gmail.com",(List<Role>) etudientRole, "etud17", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0011", filiere2, null,null, null));
		Etudiant etudiant17 =etudiantRepository.save(new Etudiant(18,"anour@gmail.com",(List<Role>) etudientRole, "etud18", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0012", filiere2, null,null, null));
		Etudiant etudiant18 =etudiantRepository.save(new Etudiant(19,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "0013", filiere2, null,null, null));
		Etudiant etudiant19 =etudiantRepository.save(new Etudiant(20,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0014", filiere2, null,null, null));
		Etudiant etudiant20 =etudiantRepository.save(new Etudiant(21,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0015", filiere2, null,null, null));
		Etudiant etudiant21 =etudiantRepository.save(new Etudiant(22,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0016", filiere2, null,null, null));
		Etudiant etudiant22 =etudiantRepository.save(new Etudiant(23,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0017", filiere2, null,null, null));
		Etudiant etudiant23 =etudiantRepository.save(new Etudiant(24,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0018", filiere2, null,null, null));

		Etudiant etudiant24 =etudiantRepository.save(new Etudiant(25,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0019", filiere3, null,null, null));
		Etudiant etudiant25 =etudiantRepository.save(new Etudiant(26,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0020", filiere3, null,null, null));
		Etudiant etudiant26 =etudiantRepository.save(new Etudiant(27,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0021", filiere3, null,null, null));
		Etudiant etudiant27 =etudiantRepository.save(new Etudiant(28,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0022", filiere3, null,null, null));
		Etudiant etudiant28 =etudiantRepository.save(new Etudiant(4,"anour@gmail.com",(List<Role>) etudientRole, "etud4", "000", "000", "D12345678", "ait fal", "ossama", new Date(), "0000", "000", "0023", filiere3, null,null, null));
		Etudiant etudiant29 =etudiantRepository.save(new Etudiant(29,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "0024", filiere3, null,null, null));
		Etudiant etudiant30 =etudiantRepository.save(new Etudiant(30,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0025", filiere3, null,null, null));
		Etudiant etudiant31=etudiantRepository.save(new Etudiant(31,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0026", filiere3, null,null,null));
		Etudiant etudiant32=etudiantRepository.save(new Etudiant(32,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0027", filiere3, null,null,null));
		Etudiant etudiant33=etudiantRepository.save(new Etudiant(33,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0028", filiere3, null,null,null));

		Etudiant etudiant34=etudiantRepository.save(new Etudiant(34,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0029", filiere4, null,null,null));
		Etudiant etudiant35=etudiantRepository.save(new Etudiant(35,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0030", filiere4, null,null,null));
		Etudiant etudiant36=etudiantRepository.save(new Etudiant(36,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0031", filiere4, null,null,null));
		Etudiant etudiant37=etudiantRepository.save(new Etudiant(37,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0032", filiere4, null,null,null));
		Etudiant etudiant38=etudiantRepository.save(new Etudiant(38,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0033", filiere4, null,null,null));
		Etudiant etudiant39=etudiantRepository.save(new Etudiant(39,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "003", filiere4, null,null,null));
		Etudiant etudiant40=etudiantRepository.save(new Etudiant(40,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0034", filiere4, null,null,null));
		Etudiant etudiant41=etudiantRepository.save(new Etudiant(41,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0035", filiere4, null,null,null));
		Etudiant etudiant42=etudiantRepository.save(new Etudiant(42,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0036", filiere4, null,null,null));
		Etudiant etudiant43=etudiantRepository.save(new Etudiant(43,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0037", filiere4, null,null,null));

		Etudiant etudiant44=etudiantRepository.save(new Etudiant(44,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0038", filiere5, null,null,null));
		Etudiant etudiant45=etudiantRepository.save(new Etudiant(45,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0039", filiere5, null,null,null));
		Etudiant etudiant46=etudiantRepository.save(new Etudiant(46,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0040", filiere5, null,null,null));
		Etudiant etudiant47=etudiantRepository.save(new Etudiant(47,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0041", filiere5, null,null,null));
		Etudiant etudiant48=etudiantRepository.save(new Etudiant(48,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0042", filiere5, null,null,null));
		Etudiant etudiant49=etudiantRepository.save(new Etudiant(49,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "0043", filiere5, null,null,null));
		Etudiant etudiant50=etudiantRepository.save(new Etudiant(50,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0044", filiere5, null,null,null));
		Etudiant etudiant51=etudiantRepository.save(new Etudiant(51,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0045", filiere5, null,null,null));
		Etudiant etudiant52=etudiantRepository.save(new Etudiant(52,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0046", filiere5, null,null,null));
		Etudiant etudiant53=etudiantRepository.save(new Etudiant(53,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0047", filiere5, null,null,null));

		Etudiant etudiant54=etudiantRepository.save(new Etudiant(54,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0048", filiere6, null,null,null));
		Etudiant etudiant55=etudiantRepository.save(new Etudiant(55,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0049", filiere6, null,null,null));
		Etudiant etudiant56=etudiantRepository.save(new Etudiant(56,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0050", filiere6, null,null,null));
		Etudiant etudiant57=etudiantRepository.save(new Etudiant(57,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0051", filiere6, null,null,null));
		Etudiant etudiant58=etudiantRepository.save(new Etudiant(58,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0052", filiere6, null,null,null));
		Etudiant etudiant59=etudiantRepository.save(new Etudiant(59,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "0053", filiere6, null,null,null));
		Etudiant etudiant60=etudiantRepository.save(new Etudiant(60,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0054", filiere6, null,null,null));
		Etudiant etudiant61=etudiantRepository.save(new Etudiant(61,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0055", filiere6, null,null,null));
		Etudiant etudiant62=etudiantRepository.save(new Etudiant(62,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0056", filiere6, null,null,null));
		Etudiant etudiant63=etudiantRepository.save(new Etudiant(63,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0057", filiere6, null,null,null));

		Etudiant etudiant64=etudiantRepository.save(new Etudiant(64,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0058", filiere7, null,null,null));
		Etudiant etudiant65=etudiantRepository.save(new Etudiant(65,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0059", filiere7, null,null,null));
		Etudiant etudiant66=etudiantRepository.save(new Etudiant(67,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0060", filiere7, null,null,null));
		Etudiant etudiant67=etudiantRepository.save(new Etudiant(68,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0061", filiere7, null,null,null));
		Etudiant etudiant68=etudiantRepository.save(new Etudiant(69,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0062", filiere7, null,null,null));
		Etudiant etudiant69=etudiantRepository.save(new Etudiant(70,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozz", "abdo", new Date(), "0000", "000", "0063", filiere7, null,null,null));
		Etudiant etudiant70=etudiantRepository.save(new Etudiant(71,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0064", filiere7, null,null,null));
		Etudiant etudiant71=etudiantRepository.save(new Etudiant(72,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0065", filiere7, null,null,null));
		Etudiant etudiant72=etudiantRepository.save(new Etudiant(73,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0066", filiere7, null,null,null));
		Etudiant etudiant73=etudiantRepository.save(new Etudiant(74,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0067", filiere7, null,null,null));

		Etudiant etudiant74=etudiantRepository.save(new Etudiant(75,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0068", filiere8, null,null,null));
		Etudiant etudiant75=etudiantRepository.save(new Etudiant(77,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0069", filiere8, null,null,null));
		Etudiant etudiant76=etudiantRepository.save(new Etudiant(78,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0070", filiere8, null,null,null));
		Etudiant etudiant77=etudiantRepository.save(new Etudiant(79,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0071", filiere8, null,null,null));
		Etudiant etudiant78=etudiantRepository.save(new Etudiant(80,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0072", filiere8, null,null,null));
		Etudiant etudiant79=etudiantRepository.save(new Etudiant(81,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0073", filiere8, null,null,null));
		Etudiant etudiant80=etudiantRepository.save(new Etudiant(82,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0074", filiere8, null,null,null));
		Etudiant etudiant81=etudiantRepository.save(new Etudiant(83,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0075", filiere8, null,null,null));
		Etudiant etudiant82=etudiantRepository.save(new Etudiant(84,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0076", filiere8, null,null,null));
		Etudiant etudiant83=etudiantRepository.save(new Etudiant(85,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0077", filiere8, null,null,null));

		Etudiant etudiant84=etudiantRepository.save(new Etudiant(87,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0078", filiere9, null,null,null));
		Etudiant etudiant85=etudiantRepository.save(new Etudiant(88,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0079", filiere9, null,null,null));
		Etudiant etudiant86=etudiantRepository.save(new Etudiant(89,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0080", filiere9, null,null,null));
		Etudiant etudiant87=etudiantRepository.save(new Etudiant(90,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0081", filiere9, null,null,null));
		Etudiant etudiant88=etudiantRepository.save(new Etudiant(101,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0082", filiere9, null,null,null));
		Etudiant etudiant89=etudiantRepository.save(new Etudiant(102,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0083", filiere9, null,null,null));
		Etudiant etudiant90=etudiantRepository.save(new Etudiant(103,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0084", filiere9, null,null,null));
		Etudiant etudiant91=etudiantRepository.save(new Etudiant(104,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0085", filiere9, null,null,null));
		Etudiant etudiant92=etudiantRepository.save(new Etudiant(105,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0086", filiere9, null,null,null));
		Etudiant etudiant93=etudiantRepository.save(new Etudiant(107,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0087", filiere9, null,null,null));

		Etudiant etudiant94=etudiantRepository.save(new Etudiant(108,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0088", filiere10, null,null,null));
		Etudiant etudiant95=etudiantRepository.save(new Etudiant(109,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0089", filiere10, null,null,null));
		Etudiant etudiant96=etudiantRepository.save(new Etudiant(110,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0090", filiere10, null,null,null));
		Etudiant etudiant97=etudiantRepository.save(new Etudiant(111,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0091", filiere10, null,null,null));
		Etudiant etudiant98=etudiantRepository.save(new Etudiant(112,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0092", filiere10, null,null,null));
		Etudiant etudiant99=etudiantRepository.save(new Etudiant(113,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0093", filiere10, null,null,null));
		Etudiant etudiant100=etudiantRepository.save(new Etudiant(114,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0094", filiere10, null,null,null));
		Etudiant etudiant101=etudiantRepository.save(new Etudiant(115,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0095", filiere10, null,null,null));
		Etudiant etudiant102=etudiantRepository.save(new Etudiant(116,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0096", filiere10, null,null,null));
		Etudiant etudiant103=etudiantRepository.save(new Etudiant(117,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0097", filiere10, null,null,null));

		Etudiant etudiant104=etudiantRepository.save(new Etudiant(118,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0098", filiere11, null,null,null));
		Etudiant etudiant105=etudiantRepository.save(new Etudiant(119,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0100", filiere11, null,null,null));
		Etudiant etudiant106=etudiantRepository.save(new Etudiant(120,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0101", filiere11, null,null,null));
		Etudiant etudiant107=etudiantRepository.save(new Etudiant(121,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0102", filiere11, null,null,null));
		Etudiant etudiant108=etudiantRepository.save(new Etudiant(122,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0103", filiere11, null,null,null));
		Etudiant etudiant109=etudiantRepository.save(new Etudiant(123,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0104", filiere11, null,null,null));
		Etudiant etudiant110=etudiantRepository.save(new Etudiant(124,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0105", filiere11, null,null,null));
		Etudiant etudiant111=etudiantRepository.save(new Etudiant(125,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0106", filiere11, null,null,null));
		Etudiant etudiant112=etudiantRepository.save(new Etudiant(126,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0107", filiere11, null,null,null));
		Etudiant etudiant113=etudiantRepository.save(new Etudiant(127,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0108", filiere11, null,null,null));

		Etudiant etudiant114=etudiantRepository.save(new Etudiant(128,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0109", filiere6, null,null,null));
		Etudiant etudiant115=etudiantRepository.save(new Etudiant(129,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0110", filiere6, null,null,null));
		Etudiant etudiant116=etudiantRepository.save(new Etudiant(130,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0111", filiere6, null,null,null));
		Etudiant etudiant117=etudiantRepository.save(new Etudiant(131,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0112", filiere6, null,null,null));
		Etudiant etudiant118=etudiantRepository.save(new Etudiant(132,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0113", filiere6, null,null,null));
		Etudiant etudiant119=etudiantRepository.save(new Etudiant(133,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0114", filiere6, null,null,null));
		Etudiant etudiant120=etudiantRepository.save(new Etudiant(134,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0115", filiere6, null,null,null));
		Etudiant etudiant121=etudiantRepository.save(new Etudiant(135,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0116", filiere6, null,null,null));
		Etudiant etudiant122=etudiantRepository.save(new Etudiant(136,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0117", filiere6, null,null,null));
		Etudiant etudiant123=etudiantRepository.save(new Etudiant(137,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0118", filiere6, null,null,null));

		Etudiant etudiant124=etudiantRepository.save(new Etudiant(138,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0119", filiere8, null,null,null));
		Etudiant etudiant125=etudiantRepository.save(new Etudiant(139,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0120", filiere8, null,null,null));
		Etudiant etudiant126=etudiantRepository.save(new Etudiant(140,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0121", filiere8, null,null,null));
		Etudiant etudiant127=etudiantRepository.save(new Etudiant(141,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0122", filiere8, null,null,null));
		Etudiant etudiant128=etudiantRepository.save(new Etudiant(142,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0123", filiere8, null,null,null));
		Etudiant etudiant129=etudiantRepository.save(new Etudiant(143,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0124", filiere8, null,null,null));
		Etudiant etudiant130=etudiantRepository.save(new Etudiant(144,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0125", filiere8, null,null,null));
		Etudiant etudiant131=etudiantRepository.save(new Etudiant(145,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0126", filiere8, null,null,null));
		Etudiant etudiant132=etudiantRepository.save(new Etudiant(146,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0127", filiere8, null,null,null));
		Etudiant etudiant133=etudiantRepository.save(new Etudiant(147,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0128", filiere8, null,null,null));

		Etudiant etudiant134=etudiantRepository.save(new Etudiant(148,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0129", filiere10, null,null,null));
		Etudiant etudiant135=etudiantRepository.save(new Etudiant(149,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0130", filiere10, null,null,null));
		Etudiant etudiant136=etudiantRepository.save(new Etudiant(150,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0131", filiere10, null,null,null));
		Etudiant etudiant137=etudiantRepository.save(new Etudiant(151,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0132", filiere10, null,null,null));
		Etudiant etudiant138=etudiantRepository.save(new Etudiant(152,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0133", filiere10, null,null,null));
		Etudiant etudiant139=etudiantRepository.save(new Etudiant(153,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0134", filiere10, null,null,null));
		Etudiant etudiant140=etudiantRepository.save(new Etudiant(154,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0135", filiere10, null,null,null));
		Etudiant etudiant141=etudiantRepository.save(new Etudiant(155,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0136", filiere10, null,null,null));
		Etudiant etudiant142=etudiantRepository.save(new Etudiant(156,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0137", filiere10, null,null,null));
		Etudiant etudiant143=etudiantRepository.save(new Etudiant(157,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0138", filiere10, null,null,null));

		Etudiant etudiant144=etudiantRepository.save(new Etudiant(158,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0139", filiere11, null,null,null));
		Etudiant etudiant145=etudiantRepository.save(new Etudiant(159,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "kabiri", "zakaria", new Date(), "0000", "000", "0140", filiere11, null,null,null));
		Etudiant etudiant146=etudiantRepository.save(new Etudiant(160,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "daysii", "jalal", new Date(), "0000", "000", "0141", filiere11, null,null,null));
		Etudiant etudiant147=etudiantRepository.save(new Etudiant(161,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "hayani", "hassan", new Date(), "0000", "000", "0142", filiere11, null,null,null));
		Etudiant etudiant148=etudiantRepository.save(new Etudiant(162,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "ggfk", "vitch", new Date(), "0000", "000", "0143", filiere11, null,null,null));
		Etudiant etudiant149=etudiantRepository.save(new Etudiant(163,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foazi", "khalid", new Date(), "0000", "000", "0144", filiere11, null,null,null));
		Etudiant etudiant150=etudiantRepository.save(new Etudiant(164,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "dozzi", "hamza", new Date(), "0000", "000", "0145", filiere11, null,null,null));
		Etudiant etudiant151=etudiantRepository.save(new Etudiant(165,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "haji", "simo", new Date(), "0000", "000", "0146", filiere11, null,null,null));
		Etudiant etudiant152=etudiantRepository.save(new Etudiant(166,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "foaz", "ihya", new Date(), "0000", "000", "0147", filiere11, null,null,null));
		Etudiant etudiant153=etudiantRepository.save(new Etudiant(167,"anour@gmail.com",(List<Role>) etudientRole, "589@gmail.com", "000", "000", "D12345678", "madin", "ayoub", new Date(), "0000", "000", "0148", filiere11, null,null,null));


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

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant4, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant5, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant6, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant7, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant8, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant9, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant10, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant11, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant12, model25));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant13, model25));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant14, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant15, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant16, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant17, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant18, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant19, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant20, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant21, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant22, model8));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant23, model8));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant14, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant15, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant16, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant17, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant18, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant19, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant20, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant21, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant22, model30));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant23, model30));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant24, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant25, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant26, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant27, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant28, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant29, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant30, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant31, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant32, model29));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant33, model29));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant24, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant25, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant26, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant27, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant28, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant29, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant30, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant31, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant32, model4));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant33, model4));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant34, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant35, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant36, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant37, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant38, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant39, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant40, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant41, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant42, model24));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant43, model24));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant34, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant35, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant36, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant37, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant38, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant39, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant40, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant41, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant42, model2));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant43, model2));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant44, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant45, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant46, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant47, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant48, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant49, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant50, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant51, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant52, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant53, model15));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant44, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant45, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant46, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant47, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant48, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant49, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant50, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant51, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant52, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant53, model28));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant54, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant55, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant56, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant57, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant58, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant59, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant60, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant61, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant62, model1));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant63, model1));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant54, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant55, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant56, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant57, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant58, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant59, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant60, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant61, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant62, model3));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant63, model3));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant64, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant65, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant66, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant67, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant68, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant69, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant70, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant71, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant72, model17));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant73, model17));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant64, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant65, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant66, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant67, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant68, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant69, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant70, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant71, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant72, model26));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant73, model26));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant74, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant75, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant76, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant77, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant78, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant79, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant80, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant81, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant82, model20));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant83, model20));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant74, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant75, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant76, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant77, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant78, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant79, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant80, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant81, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant82, model22));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant83, model22));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant84, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant85, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant86, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant87, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant88, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant89, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant90, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant91, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant92, model19));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant93, model19));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant84, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant85, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant86, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant87, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant88, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant89, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant90, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant91, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant92, model18));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant93, model18));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant94, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant95, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant96, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant97, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant98, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant99, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant100, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant101, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant102, model16));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant103, model16));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant94, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant95, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant96, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant97, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant98, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant99, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant100, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant101, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant102, model27));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant103, model27));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant104, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant105, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant106, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant107, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant108, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant109, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant110, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant111, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant112, model14));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant113, model14));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant104, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant105, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant106, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant107, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant108, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant109, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant110, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant111, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant112, model12));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant113, model12));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant114, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant115, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant116, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant117, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant118, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant119, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant120, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant121, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant122, model5));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant123, model5));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant114, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant115, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant116, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant117, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant118, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant119, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant120, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant121, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant122, model9));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant123, model9));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant124, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant125, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant126, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant127, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant128, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant129, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant130, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant131, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant132, model6));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant133, model6));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant124, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant125, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant126, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant127, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant128, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant129, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant130, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant131, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant132, model10));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant133, model10));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant134, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant135, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant136, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant137, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant138, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant139, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant140, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant141, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant142, model15));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant143, model15));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant134, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant135, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant136, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant137, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant138, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant139, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant140, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant141, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant142, model28));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant143, model28));

		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant144, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant145, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant146, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant147, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant148, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant149, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant150, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant151, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant152, model13));
		etudiantHasModuleRepository.save(new EtudiantHasModule(annee1, etudiant153, model13));





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