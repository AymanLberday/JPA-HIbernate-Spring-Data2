package ma.ayman.hospital.service;

import ma.ayman.hospital.entities.Consultation;
import ma.ayman.hospital.entities.Medecin;
import ma.ayman.hospital.entities.Patient;
import ma.ayman.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
