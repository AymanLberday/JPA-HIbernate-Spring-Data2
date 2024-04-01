package ma.ayman.hospital.repositories;

import ma.ayman.hospital.entities.Consultation;
import ma.ayman.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
