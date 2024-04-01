package ma.ayman.hospital.repositories;

import ma.ayman.hospital.entities.Medecin;
import ma.ayman.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
