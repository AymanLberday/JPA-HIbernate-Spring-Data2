package ma.ayman.hospital.repositories;

import ma.ayman.hospital.entities.Patient;
import ma.ayman.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
