package ma.ayman.hospital;

import ma.ayman.hospital.entities.*;
import ma.ayman.hospital.repositories.ConsultationRepository;
import ma.ayman.hospital.repositories.MedecinRepository;
import ma.ayman.hospital.repositories.PatientRepository;
import ma.ayman.hospital.repositories.RendezVousRepository;
import ma.ayman.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,RendezVousRepository rendezVousRepository,MedecinRepository medecinRepository){
		return args -> {
				Stream.of("Mohamed","Hassan","Najat")
						.forEach(name->{
							Patient patient=new Patient();
							patient.setNom(name);
							patient.setDateNaissance(new Date());
							patient.setMalade(false);
							hospitalService.savePatient(patient);
				});
			Stream.of("Ayman","Hanane","yasmine")
					.forEach(name->{
						Medecin medecin=new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						hospitalService.saveMedecin(medecin);
					});

			Patient patient=patientRepository.findById(1L).orElse(null);
			Patient patient1=patientRepository.findByNom("Mohamed");

			Medecin medecin=medecinRepository.findByNom("yasmine");

			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous saveRDV = hospitalService.saveRDV(rendezVous);
			System.out.println(saveRDV.getId());

			RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation .....");
			hospitalService.saveConsultation(consultation);

		};
	}
}
