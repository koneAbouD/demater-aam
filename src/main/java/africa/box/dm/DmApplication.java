package africa.box.dm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class DmApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmApplication.class, args);
	}


//	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
		properties.setLocation(new FileSystemResource("/home/AdminLocal/JarFiles/application.yaml"));
		properties.setIgnoreResourceNotFound(false);

		return properties;
	}

//properties.setLocation(new FileSystemResource("C:\\Users\\VAS 6\\Box-arica\\BDU_AAM_BackOffice_BackEnd\\BackOffice_Ba
}
/*
    +++++++++++++++++++++++++++ APP'S PROCESS +++++++++++++++++++++++++++
    Création de compte => CompteController *
    Liste des comptes => CompteController getAll()
    Détails d'un compte => CompteController getCompte()
        Information sur le compte => CompteController getCompte()
        Chargement des fichiers => DocUploadController handleFileUpload()
        Enregistrement des meta données => DocUploadController updateDocMetaData()
        Approbation => CompteController approbation()

    ++++++++++++++++++++++++ Note Process +++++++++++++++++++++
    Création de compte => Status INFORMATION
    Dossier En attente => Status INFORMATION
    Dossier En traitement => Status INFORMATION
    Dossier Approuvé | Refusé | A Compléter => Status DECISION
*/